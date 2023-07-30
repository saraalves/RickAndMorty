package com.saraalves.rickandmorty.data.repository.location

import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSource
import com.saraalves.rickandmorty.domain.model.response.location.Location
import com.saraalves.rickandmorty.domain.model.response.location.ResultsLocation
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class LocationRepositoryImpl(private val locationRemoteDataSource: LocationRemoteDataSource) :
    LocationRepository {
    override fun getAllLocation(page: Int): Flow<Location> = flow {
        getAllLocationData(page).collect{ remoteList ->
            emit(remoteList)
        }
    }

    override fun getLocation(id: Int): Flow<List<ResultsLocation>> {
        TODO("Not yet implemented")
    }

    override fun getAllLocationData(page: Int): Flow<Location> =
        locationRemoteDataSource.getAllLocations(page)
}