package com.saraalves.rickandmorty.domain.repository.location

import com.saraalves.rickandmorty.domain.model.response.location.Location
import com.saraalves.rickandmorty.domain.model.response.location.ResultsLocation
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocation(page: Int): Flow<Location>
    fun getLocation(id: Int): Flow<List<ResultsLocation>>
    fun getAllLocationData(page: Int): Flow<Location>
}