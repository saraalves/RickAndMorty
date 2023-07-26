package com.example.rickandmorty.data.mapper.character

import com.example.rickandmorty.data.extensions.mapper.mapToLocation
import com.example.rickandmorty.data.extensions.mapper.mapToOrigin
import com.example.rickandmorty.data.mapper.Mapper
import com.example.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.example.rickandmorty.domain.model.response.Character
import com.example.rickandmorty.domain.model.response.Location
import com.example.rickandmorty.domain.model.response.Origin

class CharacterResponseToModelMapper : Mapper<List<CharacterResponse>, List<Character>> {
    override fun map(source: List<CharacterResponse>): List<Character> = source.map {
        Character(
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