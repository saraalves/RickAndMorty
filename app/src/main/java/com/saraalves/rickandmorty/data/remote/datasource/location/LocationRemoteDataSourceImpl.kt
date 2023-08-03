package com.saraalves.rickandmorty.data.remote.datasource.location

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.location.AllLocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.location.LocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.RickAndMortyApi
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocationRemoteDataSourceImpl(
    private val locationApi: RickAndMortyApi,
    private val allLocationMapper: AllLocationMapperResponseToModelMapper,
    private val locationMapper: LocationMapperResponseToModelMapper
) : LocationRemoteDataSource {
    override fun getAllLocations(page: Int): Flow<AllLocation> {
        return flow { emit(allLocationMapper.map(locationApi.getAllLocation(page))) }.parseHttpError()
    }

    override fun getSingleLocation(id: Int): Flow<List<SingleLocation>> {
        return flow { emit(locationMapper.map(locationApi.getSingleLocation())) }.parseHttpError()
    }
}