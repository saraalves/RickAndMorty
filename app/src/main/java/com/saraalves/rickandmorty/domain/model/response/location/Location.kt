package com.saraalves.rickandmorty.domain.model.response.location

import com.saraalves.rickandmorty.domain.model.response.Info


data class Location(
    val infoLocation: Info? = null,
    val results: List<ResultsLocation> = listOf(),
)
