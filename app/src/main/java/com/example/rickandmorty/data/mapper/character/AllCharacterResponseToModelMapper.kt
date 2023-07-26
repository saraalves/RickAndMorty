package com.example.rickandmorty.data.mapper.character

import com.example.rickandmorty.data.extensions.mapper.mapToLocation
import com.example.rickandmorty.data.extensions.mapper.mapToOrigin
import com.example.rickandmorty.data.mapper.Mapper
import com.example.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.example.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.domain.model.response.Character

class AllCharacterResponseToModelMapper : Mapper<List<AllCharacterResponse>, List<AllCharacters>> {
    override fun map(source: List<AllCharacterResponse>): List<AllCharacters> = source.map {
        AllCharacters(
            info = it.info,
            results = it.results.mapToListResults()
        )
    }

    private fun List<CharacterResponse>.mapToListResults(): List<Character> = map {
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

//    private fun OriginResponse.mapToOrigin(): Origin {
//        return Origin(
//            name = this.originName,
//            url = this.originUrl
//        )
//    }
//
//    private fun LocationResponse.mapToLocation(): Location {
//        return Location(
//            infoLocation = this.infoLocation.mapToInfoLocations(),
//            results = this.results.mapToResults()
//        )
//    }
//
//    private fun InfoResponse.mapToInfoLocations(): Info {
//        return Info(
//            count = this.count,
//            pages = this.pages,
//            next = this.next,
//            prev = this.prev
//        )
//    }
//
//    private fun List<ResultsLocationResponse>.mapToResults(): List<ResultsLocation> = map {
//        ResultsLocation(
//            id = it.id,
//            locationName = it.locationName,
//            type = it.type,
//            dimension = it.dimension,
//            residents = it.residents,
//            locationUrl = it.locationUrl,
//            createdLocation = it.createdLocation
//        )
//    }
}
