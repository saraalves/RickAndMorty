package com.example.rickandmorty.domain.model.response

data class Character(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: Origin? = null,
    val location: Location? = null,
    val image: String? = null,
    val episode: List<String> = listOf(),
    val url: String? = null,
    val created: String? = null,
)