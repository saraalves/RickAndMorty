package com.saraalves.rickandmorty.data.mapper.character

import com.saraalves.rickandmorty.data.extensions.mapper.mapToInfo
import com.saraalves.rickandmorty.data.extensions.mapper.mapToLocation
import com.saraalves.rickandmorty.data.extensions.mapper.mapToOrigin
import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.InfoResponse
import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.domain.model.response.Info
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter

class AllCharacterResponseToModelMapper : Mapper<AllCharacterResponse, AllCharacters> {
    override fun map(source: AllCharacterResponse): AllCharacters {
        return AllCharacters(
//            info = source.info.mapToInfo(),
            results = source.results.mapToListResults()
        )
    }

    private fun List<CharacterResponse>.mapToListResults(): List<SingleCharacter> = map {
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
