package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.annotation.KSerialization
import com.saraalves.rickandmorty.data.remote.model.response.commom.ResultsLocationResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @KSerialization
    @GET("location")
    suspend fun getSingleLocation(): List<ResultsLocationResponse>

    @KSerialization
    @GET("location")
    suspend fun getAllLocation(@Query("page") page: Int): LocationResponse
}