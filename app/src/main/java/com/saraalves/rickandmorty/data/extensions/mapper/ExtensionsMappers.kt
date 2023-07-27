package com.saraalves.rickandmorty.data.extensions.mapper

import com.saraalves.rickandmorty.data.remote.model.response.InfoResponse
import com.saraalves.rickandmorty.data.remote.model.response.OriginResponse
import com.saraalves.rickandmorty.data.remote.model.response.ResultsLocationResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import com.saraalves.rickandmorty.domain.model.response.Info
import com.saraalves.rickandmorty.domain.model.response.Location
import com.saraalves.rickandmorty.domain.model.response.Origin
import com.saraalves.rickandmorty.domain.model.response.ResultsLocation

fun OriginResponse.mapToOrigin(): Origin {
    return Origin(
        name = this.originName,
        url = this.originUrl
    )
}

fun LocationResponse.mapToLocation(): Location {
    return Location(
        infoLocation = this.infoLocation.mapToInfoLocations(),
        results = this.results.mapToResults()
    )
}

private fun InfoResponse.mapToInfoLocations(): Info {
    return Info(
        count = this.count,
        pages = this.pages,
        next = this.next,
        prev = this.prev
    )
}

private fun List<ResultsLocationResponse>.mapToResults(): List<ResultsLocation> = map {
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