package com.saraalves.rickandmorty.data.mapper.location

import com.saraalves.rickandmorty.data.extensions.mapper.mapToLocation
import com.saraalves.rickandmorty.data.extensions.mapper.mapToOrigin
import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.ResultsLocationResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.domain.model.response.location.ResultsLocation

class LocationMapperResponseToModelMapper : Mapper<List<ResultsLocationResponse>, List<ResultsLocation>> {
    override fun map(source: List<ResultsLocationResponse>): List<ResultsLocation> = source.map {
        ResultsLocation(
            id = it.id,
            locationName = it.locationName,
            type = it.type,
            dimension = it.dimension,
            residents = it.residents,
            locationUrl = it.locationUrl,
            createdLocation = it.createdLocation
        )
    }
}