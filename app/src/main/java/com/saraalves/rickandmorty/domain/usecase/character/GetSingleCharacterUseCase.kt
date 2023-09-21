package com.saraalves.rickandmorty.domain.usecase.character

import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetSingleCharacterUseCase(private val repository: CharacterRepository) {
    operator fun invoke(id: Int?): Flow<SingleCharacter> = repository.getSingleCharacter(id)
}