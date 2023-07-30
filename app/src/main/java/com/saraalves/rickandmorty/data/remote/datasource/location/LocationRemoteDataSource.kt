package com.saraalves.rickandmorty.data.remote.datasource.location

import com.saraalves.rickandmorty.domain.model.response.location.Location
import com.saraalves.rickandmorty.domain.model.response.location.ResultsLocation
import kotlinx.coroutines.flow.Flow

interface LocationRemoteDataSource {

    fun getAllLocations(page: Int): Flow<Location>
    fun getSingleLocation(id: Int): Flow<List<ResultsLocation>>
}