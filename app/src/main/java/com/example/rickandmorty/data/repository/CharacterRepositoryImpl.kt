package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.remote.datasource.CharacterRemoteDataSource
import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.domain.model.response.Character
import com.example.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(private val characterRemoteDataSource: CharacterRemoteDataSource) : CharacterRepository {
    override fun getAllCharacters(): Flow<List<AllCharacters>> = flow {
        getAllCharactersData().collect{ remoteList ->
            emit(remoteList)
        }
    }

    override fun getCharacters(id: Int): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override fun getAllCharactersData(): Flow<List<AllCharacters>> = characterRemoteDataSource.getAllCharacters()
}