package com.saraalves.rickandmorty.domain.model.response.character

import com.saraalves.rickandmorty.domain.model.response.location.Location
import com.saraalves.rickandmorty.domain.model.response.Origin

data class SingleCharacter(
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