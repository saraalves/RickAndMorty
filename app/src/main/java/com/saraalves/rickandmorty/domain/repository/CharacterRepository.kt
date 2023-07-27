package com.saraalves.rickandmorty.domain.repository

import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<List<AllCharacters>>
    fun getCharacters(id: Int): Flow<List<SingleCharacter>>
    fun getAllCharactersData(): Flow<List<AllCharacters>>
}