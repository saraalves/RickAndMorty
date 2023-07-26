package com.example.rickandmorty.domain.model.response

import com.example.rickandmorty.data.remote.model.response.InfoResponse

data class AllCharacters(
    val info: InfoResponse,
    val results: List<Character> = listOf()
)