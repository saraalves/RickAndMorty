package com.saraalves.rickandmorty.domain.model.response

import com.saraalves.rickandmorty.data.remote.model.response.InfoResponse

data class AllCharacters(
    val info: InfoResponse,
    val results: List<SingleCharacter> = listOf()
)