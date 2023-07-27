package com.saraalves.rickandmorty.di

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.RickAndMortyApi
import com.saraalves.rickandmorty.data.remote.datasource.CharacterRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.CharacterRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.repository.CharacterRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.CharacterRepository
import com.saraalves.rickandmorty.domain.usecase.GetAllCharacterUseCase
import com.saraalves.rickandmorty.presentation.viewmodel.CharacterViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val chracterViewModel = module {
    viewModel { CharacterViewModel(get())}
}

val characterUseCaseModule = module {
    single { GetAllCharacterUseCase(get()) }
}

val mapperModule = module {
    single { AllCharacterResponseToModelMapper() }
    single { CharacterResponseToModelMapper() }
}

val dataSourceModule = module {
    single<CharacterRemoteDataSource> {
        CharacterRemoteDataSourceImpl(
            characterApi = get(),
            allCharacterMapper = get(),
            characterMapper = get()
        )
    }
}
val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}
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