package com.example.rickandmorty.data.remote.model.response.location

import com.example.rickandmorty.data.remote.model.response.InfoResponse
import com.example.rickandmorty.data.remote.model.response.ResultsLocationResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    @SerialName("info") val infoLocation: InfoResponse,
    @SerialName("results") val results: List<ResultsLocationResponse> = listOf(),
)