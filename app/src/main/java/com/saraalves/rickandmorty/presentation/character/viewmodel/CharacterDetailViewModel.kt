package com.saraalves.rickandmorty.presentation.character.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.UIState
import com.saraalves.rickandmorty.domain.CharacterState
import com.saraalves.rickandmorty.domain.StateError
import com.saraalves.rickandmorty.domain.exception.ConnectionError
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.usecase.character.GetSingleCharacterUseCase
import com.saraalves.rickandmorty.presentation.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.lang.Error

class CharacterDetailViewModel(
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    // pensar em criar um state no final como odo picpay por exemplo

    private var _singleCharacterState = MutableLiveData<CharacterState>()
    val singleCharacterState: LiveData<CharacterState> = _singleCharacterState

    private val characterState: CharacterState = CharacterState()

    private val _singleCharacter = MutableLiveData<SingleCharacter>()
    var singleCharacter: LiveData<SingleCharacter> = _singleCharacter

    private val _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Pair<Int, Int>>()
    var error: LiveData<Pair<Int, Int>> = _error


    fun getSingleCharacter(id: Int) {
        viewModelScope.launch {
            getSingleCharacterUseCase(id)
                .flowOn(dispatcher)
                .onStart {
                    _singleCharacterState.value = characterState.copy(
                        isLoading = true
                    )
                }
                .catch { handleError(it) }
                .collect {
                    _singleCharacterState.value = characterState.copy(
                        isError = null,
                        isLoading = false,
                        characterData = it
                    )
                }
        }

    }

    private fun handleError(error: Throwable) {
        when (error) {
            is ConnectionError -> _singleCharacterState.value = characterState.copy(
                isLoading = false,
                isError = StateError(
                    title = "Ops, sem conexão",
                    message =  "Sem conexão com a internet."
                )
            )

            else -> _singleCharacterState.value = characterState.copy(
                isLoading = false,
                isError = StateError(
                    title = "Opa! Erramos por aqui",
                    message =  "Tivemos uma falha no sistema e não conseguimos carregar essas informações."
                )
            )
        }
    }

}