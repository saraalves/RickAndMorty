package com.example.rickandmorty.data.remote.model.response.allCharacters

import com.example.rickandmorty.data.remote.model.response.InfoResponse
import com.example.rickandmorty.data.remote.model.response.character.CharacterResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllCharacterResponse(
    @SerialName("info") val info: InfoResponse,
    @SerialName("results") val results: List<CharacterResponse> = listOf()

)