package com.saraalves.rickandmorty.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraalves.rickandmorty.domain.exception.ConnectionError
import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import com.saraalves.rickandmorty.domain.usecase.GetAllCharacterUseCase
import com.saraalves.rickandmorty.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getAllCharacterUseCase: GetAllCharacterUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _allCharacters = MutableLiveData<AllCharacters>()
    var allCharacters: LiveData<AllCharacters> = _allCharacters

    private val _characters = MutableLiveData<List<SingleCharacter>>()
    var characters: LiveData<List<SingleCharacter>> = _characters

    private val _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Pair<Int, Int>>()
    var error: LiveData<Pair<Int, Int>> = _error

    fun getAllCharacters() {
        viewModelScope.launch {
            getAllCharacterUseCase()
                .flowOn(dispatcher)
                .onStart { _loading.value = true }
                .catch { handleError(it) }
                .onCompletion { _loading.value = false }
                .collect { _allCharacters.value = it}
        }

    }

    private fun handleError(error: Throwable) {
        when (error) {
            is ConnectionError -> _error.value = Pair(R.string.connection_error_title, R.string.connection_error_msg)
            else -> _error.value = Pair(R.string.error_title, R.string.error_msg)
        }
    }


}