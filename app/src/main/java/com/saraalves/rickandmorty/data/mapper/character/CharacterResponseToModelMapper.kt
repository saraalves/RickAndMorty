package com.saraalves.rickandmorty.data.mapper.character

import com.saraalves.rickandmorty.data.extensions.mapper.mapToLocation
import com.saraalves.rickandmorty.data.extensions.mapper.mapToOrigin
import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter

class CharacterResponseToModelMapper : Mapper<CharacterResponse, SingleCharacter> {
    override fun map(source: CharacterResponse): SingleCharacter {
         return SingleCharacter(
            id = source.id,
            name = source.name,
            status = source.status,
            species = source.species,
            type = source.type,
            gender = source.gender,
            origin = source.origin?.mapToOrigin(),
            location = source.location?.mapToLocation(),
            image = source.image,
            episode = source.episode,
            url = source.url,
            created = source.created

        )
    }
}