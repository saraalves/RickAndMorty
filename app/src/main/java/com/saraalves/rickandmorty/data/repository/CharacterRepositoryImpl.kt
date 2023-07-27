package com.saraalves.rickandmorty.data.repository

import com.saraalves.rickandmorty.data.remote.datasource.CharacterRemoteDataSource
import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import com.saraalves.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(private val characterRemoteDataSource: CharacterRemoteDataSource) : CharacterRepository {
    override fun getAllCharacters(): Flow<AllCharacters> = flow {
        getAllCharactersData().collect{ remoteList ->
            emit(remoteList)
        }
    }

    override fun getCharacters(id: Int): Flow<List<SingleCharacter>> {
        TODO("Not yet implemented")
    }

    override fun getAllCharactersData(): Flow<AllCharacters> = characterRemoteDataSource.getAllCharacters()
}