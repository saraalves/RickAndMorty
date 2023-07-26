package com.example.rickandmorty.data.remote.datasource

import com.example.rickandmorty.data.extensions.parseHttpError
import com.example.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.example.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
import com.example.rickandmorty.data.remote.api.RickAndMortyApi
import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.domain.model.response.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRemoteDataSourceImpl(
    private val characterApi: RickAndMortyApi,
    private val allCharacterMapper: AllCharacterResponseToModelMapper,
    private val characterMapper: CharacterResponseToModelMapper
) : CharacterRemoteDataSource {
    override fun getAllCharacters(): Flow<List<AllCharacters>> {
        return flow { emit(allCharacterMapper.map(characterApi.getAllCharacters())) }.parseHttpError()
    }

    override fun getSingleCharacter(id: Int): Flow<List<Character>> {
        return flow { emit(characterMapper.map(characterApi.getSingleCharacter(id))) }.parseHttpError()
    }
}