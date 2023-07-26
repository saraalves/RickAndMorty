package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.domain.model.response.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<List<AllCharacters>>
    fun getCharacters(id: Int): Flow<List<Character>>
    fun getAllCharactersData(): Flow<List<AllCharacters>>
}