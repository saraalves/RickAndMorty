package com.saraalves.rickandmorty.data.remote.api

import com.saraalves.rickandmorty.data.remote.annotation.KSerialization
import com.saraalves.rickandmorty.data.remote.model.response.episodes.AllEpisodesResponse
import com.saraalves.rickandmorty.data.remote.model.response.episodes.ResultsEpisodesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApi {

    @KSerialization
    @GET("episode/id")
    suspend fun getSingleEpisode(@Path("id") id: Int): List<ResultsEpisodesResponse>

    @GET("episode")
    suspend fun getAllEpisode(@Query("page") page: Int): AllEpisodesResponse
}