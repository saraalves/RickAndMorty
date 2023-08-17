package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.annotation.KSerialization
import com.saraalves.rickandmorty.data.remote.model.response.allCharacters.AllCharacterResponse
import com.saraalves.rickandmorty.data.remote.model.response.character.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface CharacterApi {

    @KSerialization
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): AllCharacterResponse

    @KSerialization
    @GET("character/id")
    suspend fun getSingleCharacter(@Path("id") id: Int): List<CharacterResponse>
}