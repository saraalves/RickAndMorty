package com.saraalves.rickandmorty.data.mapper.character

import com.saraalves.rickandmorty.data.extensions.mapper.mapToLocation
import com.saraalves.rickandmorty.data.extensions.mapper.mapToOrigin
import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter

class CharacterResponseToModelMapper : Mapper<List<CharacterResponse>, List<SingleCharacter>> {
    override fun map(source: List<CharacterResponse>): List<SingleCharacter> = source.map {
        SingleCharacter(
            id = it.id,
            name = it.name,
            status = it.status,
            species = it.species,
            type = it.type,
            gender = it.gender,
            origin = it.origin?.mapToOrigin(),
            location = it.location?.mapToLocation(),
            image = it.image,
            episode = it.episode,
            url = it.url,
            created = it.created

        )
    }
}