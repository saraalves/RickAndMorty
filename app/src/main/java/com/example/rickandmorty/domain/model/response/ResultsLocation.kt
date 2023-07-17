package com.example.rickandmorty.domain.model.response

data class ResultsLocation(
    val id: Int? = null,
    val locationName: String? = null,
    val type: String? = null,
    val dimension: String? = null,
    val residents: List<String> = listOf(),
    val locationUrl: String? = null,
    val createdLocation: String? = null,
)