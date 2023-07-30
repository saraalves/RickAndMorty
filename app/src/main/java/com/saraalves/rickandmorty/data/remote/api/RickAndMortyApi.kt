package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.annotation.KSerialization
import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.location.LocationResponse
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

//    @GET("character")
//    suspend fun getAMultipleCharacters(): List<AllCharacterResponse>

    @KSerialization
    @GET("location")
    suspend fun getSingleLocation(): List<LocationResponse>

    @KSerialization
    @GET("location")
    suspend fun getAllLocation(): List<LocationResponse>

//    @GET("location")
//    suspend fun getMultipleLocation(): List<LocationResponse>

    @KSerialization
    @GET("episode")
    suspend fun getSingleEpisode(): List<LocationResponse>
    @GET("episode")
    suspend fun getAllEpisode(): List<LocationResponse>

//    @GET("episode")
//    suspend fun getMultipleEpisode(): List<LocationResponse>



}