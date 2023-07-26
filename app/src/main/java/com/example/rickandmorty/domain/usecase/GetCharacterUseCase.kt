package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacterUseCase(private val repository: CharacterRepository) {
    operator fun invoke(): Flow<List<AllCharacters>> = repository.getAllCharacters()
}