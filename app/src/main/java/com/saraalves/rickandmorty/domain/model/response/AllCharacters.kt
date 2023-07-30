package com.saraalves.rickandmorty.domain.model.response

data class AllCharacters(
    val info: Info,
    val results: List<SingleCharacter> = listOf()
)

