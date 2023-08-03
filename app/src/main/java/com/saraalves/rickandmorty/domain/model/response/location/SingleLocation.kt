package com.saraalves.rickandmorty.domain.model.response.location

data class SingleLocation(
    val id: Int? = null,
    val locationName: String? = null,
    val type: String? = null,
    val dimension: String? = null,
    val residents: List<String> = listOf(),
    val locationUrl: String? = null,
    val createdLocation: String? = null,
)