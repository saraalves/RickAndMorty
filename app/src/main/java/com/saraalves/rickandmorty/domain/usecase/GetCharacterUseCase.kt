package com.saraalves.rickandmorty.domain.usecase

import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import com.saraalves.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacterUseCase(private val repository: CharacterRepository) {
    operator fun invoke(): Flow<AllCharacters> = repository.getAllCharacters()
}