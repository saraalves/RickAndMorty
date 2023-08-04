package com.saraalves.rickandmorty.domain.model.response.episodes

import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter

data class SingleEpisode(
    val id: Int? = null,
    val name: String? = null,
    val airDate: String? = null,
    val episode: String? = null,
    val characters: List<String> = listOf(),
    val url: String? = null,
    val created: String? = null


)
