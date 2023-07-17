package com.example.rickandmorty.di

import com.example.rickandmorty.data.remote.api.RickAndMortyApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    factory { createRetrofit().create(RickAndMortyApi::class.java) }

}
private fun createRetrofit(): Retrofit {
    val url = "https://rickandmortyapi.com/api/"
    val okHttp = OkHttpClient.Builder().build()
    val gson = GsonBuilder().create()
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}