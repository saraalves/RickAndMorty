package com.saraalves.rickandmorty.data.mapper.character

import com.saraalves.rickandmorty.data.extensions.mapper.mapToInfo
import com.saraalves.rickandmorty.data.extensions.mapper.mapToListResults
import com.saraalves.rickandmorty.data.extensions.mapper.mapToLocation
import com.saraalves.rickandmorty.data.extensions.mapper.mapToOrigin
import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter

class AllCharacterResponseToModelMapper : Mapper<AllCharacterResponse, AllCharacters> {
    override fun map(source: AllCharacterResponse): AllCharacters {
        return AllCharacters(
            info = source.info.mapToInfo(),
            results = source.results.mapToListResults()
        )
    }
}
