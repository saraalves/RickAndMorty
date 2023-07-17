package com.example.rickandmorty.data.remote.api

import com.example.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.example.rickandmorty.data.remote.model.response.location.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getAllCharacter(): List<AllCharacterResponse>

    @GET("location")
    suspend fun getLocation(): List<LocationResponse>



}