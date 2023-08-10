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
import com.saraalves.rickandmorty.data.mapper.episodes.AllEpisodeResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.episodes.EpisodesResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.location.AllLocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.location.LocationMapperResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.repository.episodes.EpisodesRepositoryImpl
import com.saraalves.rickandmorty.data.repository.location.LocationRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.episodes.EpisodesRepository
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import com.saraalves.rickandmorty.domain.usecase.episodes.GetAllEpisodesUseCase
import com.saraalves.rickandmorty.domain.usecase.location.GetLocationUseCase
import com.saraalves.rickandmorty.presentation.episodes.EpisodesViewModel
import com.saraalves.rickandmorty.presentation.location.LocationViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// alterar os nomes pra ficar generico
//remover os get() e colocar os nomes das dependencias
val chracterViewModel = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
}

val characterUseCaseModule = module {
    single { GetAllCharacterUseCase(get()) }
    single { GetLocationUseCase(get()) }
    single { GetAllEpisodesUseCase(get()) }
}

val mapperModule = module {
    single { AllCharacterResponseToModelMapper() }
    single { CharacterResponseToModelMapper() }
    single { AllLocationMapperResponseToModelMapper() }
    single { LocationMapperResponseToModelMapper() }
    single { AllEpisodeResponseToModelMapper() }
    single { EpisodesResponseToModelMapper() }
}

val dataSourceModule = module {
    single<CharacterRemoteDataSource> {
        CharacterRemoteDataSourceImpl(
            characterApi = get(),
            allCharacterMapper = get(),
            characterMapper = get()
        )
    }
    single<LocationRemoteDataSource> {
        LocationRemoteDataSourceImpl(
            locationApi = get(),
            allLocationMapper = get(),
            locationMapper = get()
        )
    }
    single<EpisodesRemoteDataSource> {
        EpisodesRemoteDataSourceImpl(
            episodesApi = get(),
            allEpisodesMapper = get(),
            episodesMapper = get()
        )
    }
}
val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
    single<LocationRepository> { LocationRepositoryImpl(get()) }
    single<EpisodesRepository> { EpisodesRepositoryImpl(get()) }
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