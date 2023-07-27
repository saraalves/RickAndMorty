package com.saraalves.rickandmorty.domain.model.response


data class Location(
    val infoLocation: Info,
    val results: List<ResultsLocation> = listOf(),
)
