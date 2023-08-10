package com.saraalves.rickandmorty.data.mapper.location

import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.commom.ResultsLocationResponse
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation

class LocationMapperResponseToModelMapper : Mapper<List<ResultsLocationResponse>, List<SingleLocation>> {
    override fun map(source: List<ResultsLocationResponse>): List<SingleLocation> = source.map {
        SingleLocation(
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