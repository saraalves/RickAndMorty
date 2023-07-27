package com.saraalves.rickandmorty.data.remote.datasource

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.RickAndMortyApi
import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRemoteDataSourceImpl(
    private val characterApi: RickAndMortyApi,
    private val allCharacterMapper: AllCharacterResponseToModelMapper,
    private val characterMapper: CharacterResponseToModelMapper
) : CharacterRemoteDataSource {
    override fun getAllCharacters(): Flow<AllCharacters> {
        return flow { emit(allCharacterMapper.map(characterApi.getAllCharacters())) }.parseHttpError()
    }

    override fun getSingleCharacter(id: Int): Flow<List<SingleCharacter>> {
        return flow { emit(characterMapper.map(characterApi.getSingleCharacter(id))) }.parseHttpError()
    }
}