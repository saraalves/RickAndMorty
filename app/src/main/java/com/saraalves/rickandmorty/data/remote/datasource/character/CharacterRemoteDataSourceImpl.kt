package com.saraalves.rickandmorty.data.remote.datasource.character

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.CharacterApi
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRemoteDataSourceImpl(
    private val characterApi: CharacterApi,
    private val allCharacterMapper: AllCharacterResponseToModelMapper,
    private val characterMapper: CharacterResponseToModelMapper
) : CharacterRemoteDataSource {
    override fun getAllCharacters(page: Int): Flow<AllCharacters> {
        return flow { emit(allCharacterMapper.map(characterApi.getAllCharacters(page))) }.parseHttpError()
    }

    override fun getSingleCharacter(id: Int?): Flow<SingleCharacter> {
        return flow { emit(characterMapper.map(characterApi.getSingleCharacter(id))) }.parseHttpError()
    }
}