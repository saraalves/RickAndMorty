package com.saraalves.rickandmorty.domain.repository.character

import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(page: Int): Flow<AllCharacters>
    fun getSingleCharacter(id: Int?): Flow<SingleCharacter>
    fun getSingleCharacterData(id: Int?): Flow<SingleCharacter>
    fun getAllCharactersData(page: Int): Flow<AllCharacters>
}