package com.example.rickandmorty.data.remote.datasource

import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.domain.model.response.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRemoteDataSource {

    fun getAllCharacters(): Flow<List<AllCharacters>>
    fun getSingleCharacter(id: Int): Flow<List<Character>>
}