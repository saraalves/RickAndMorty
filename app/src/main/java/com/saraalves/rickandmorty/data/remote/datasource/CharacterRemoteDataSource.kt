package com.saraalves.rickandmorty.data.remote.datasource

import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRemoteDataSource {

    fun getAllCharacters(): Flow<List<AllCharacters>>
    fun getSingleCharacter(id: Int): Flow<List<SingleCharacter>>
}