package com.saraalves.rickandmorty.di

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.RickAndMortyApi
import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.character.CharacterRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.repository.character.CharacterRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.character.CharacterRepository
import com.saraalves.rickandmorty.domain.usecase.character.GetAllCharacterUseCase
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterViewModel
import com.google.gson.GsonBuilder
import com.saraalves.rickandmorty.data.mapper.location.AllLocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.location.LocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.repository.location.LocationRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import com.saraalves.rickandmorty.domain.usecase.location.GetLocationUseCase
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val chracterViewModel = module {
    viewModel { CharacterViewModel(get()) }
}

val characterUseCaseModule = module {
    single { GetAllCharacterUseCase(get()) }
    single { GetLocationUseCase(get()) }
}

val mapperModule = module {
    single { AllCharacterResponseToModelMapper() }
    single { CharacterResponseToModelMapper() }
    single { AllLocationMapperResponseToModelMapper() }
    single { LocationMapperResponseToModelMapper() }
}

val dataSourceModule = module {
    single<CharacterRemoteDataSource> {
        LocationRemoteDataSourceImpl(
            locationApi = get(),
            allLocationMapper = get(),
            locationMapper = get()
        )
        CharacterRemoteDataSourceImpl(
            characterApi = get(),
            allCharacterMapper = get(),
            characterMapper = get()
        )
    }
}
val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
    single<LocationRepository> { LocationRepositoryImpl(get()) }
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