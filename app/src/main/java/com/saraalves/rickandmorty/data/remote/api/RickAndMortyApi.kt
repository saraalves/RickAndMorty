package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.annotation.KSerialization
import com.saraalves.rickandmorty.data.remote.model.response.ResultsLocationResponse
import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.episodes.AllEpisodesResponse
import com.saraalves.rickandmorty.data.remote.model.response.episodes.ResultsEpisodesResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @KSerialization
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): AllCharacterResponse

    @KSerialization
    @GET("character/id")
    suspend fun getSingleCharacter(@Path("id") id: Int): List<CharacterResponse>

    @KSerialization
    @GET("location")
    suspend fun getSingleLocation(): List<ResultsLocationResponse>

    @KSerialization
    @GET("location")
    suspend fun getAllLocation(@Query("page") page: Int): LocationResponse

    @KSerialization
    @GET("episode/id")
    suspend fun getSingleEpisode(@Path("id") id: Int): List<ResultsEpisodesResponse>

    @GET("episode")
    suspend fun getAllEpisode(@Query("page") page: Int): AllEpisodesResponse

}