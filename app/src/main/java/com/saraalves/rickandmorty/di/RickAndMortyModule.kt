package com.saraalves.rickandmorty.di

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
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
import com.saraalves.rickandmorty.data.remote.api.CharacterApi
import com.saraalves.rickandmorty.data.remote.api.EpisodeApi
import com.saraalves.rickandmorty.data.remote.api.LocationApi
import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.episodes.EpisodesRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSource
import com.saraalves.rickandmorty.data.remote.datasource.location.LocationRemoteDataSourceImpl
import com.saraalves.rickandmorty.data.repository.episodes.EpisodesRepositoryImpl
import com.saraalves.rickandmorty.data.repository.location.LocationRepositoryImpl
import com.saraalves.rickandmorty.domain.repository.episodes.EpisodesRepository
import com.saraalves.rickandmorty.domain.repository.location.LocationRepository
import com.saraalves.rickandmorty.domain.usecase.character.GetSingleCharacterUseCase
import com.saraalves.rickandmorty.domain.usecase.episodes.GetAllEpisodesUseCase
import com.saraalves.rickandmorty.domain.usecase.location.GetLocationUseCase
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterDetailViewModel
import com.saraalves.rickandmorty.presentation.episodes.EpisodesViewModel
import com.saraalves.rickandmorty.presentation.location.LocationViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        CharacterViewModel(
            GetAllCharacterUseCase(
                repository = CharacterRepositoryImpl
                    (
                    characterRemoteDataSource = CharacterRemoteDataSourceImpl(
                        characterApi = get(),
                        allCharacterMapper = AllCharacterResponseToModelMapper(),
                        characterMapper = CharacterResponseToModelMapper()
                    )
                )
            )
        )
    }
    viewModel {
        LocationViewModel(
            GetLocationUseCase(
                repository = LocationRepositoryImpl(
                    locationRemoteDataSource = LocationRemoteDataSourceImpl(
                        locationApi = get(),
                        allLocationMapper = AllLocationMapperResponseToModelMapper(),
                        locationMapper = LocationMapperResponseToModelMapper()

                    )
                )
            )
        )
    }
    viewModel {
        EpisodesViewModel(
            GetAllEpisodesUseCase(
                repository = EpisodesRepositoryImpl(
                    episodeRemoteDataSource = EpisodesRemoteDataSourceImpl(
                        episodesApi = get(),
                        allEpisodesMapper = AllEpisodeResponseToModelMapper(),
                        episodesMapper = EpisodesResponseToModelMapper()

                    )
                )
            )
        )
    }
    viewModel {
        CharacterDetailViewModel(
            GetSingleCharacterUseCase(
                repository = CharacterRepositoryImpl(
                    characterRemoteDataSource = CharacterRemoteDataSourceImpl(
                        characterApi = get(),
                        allCharacterMapper = AllCharacterResponseToModelMapper(),
                        characterMapper = CharacterResponseToModelMapper()
                    )
                )
            )

        )
    }
}

val networkModule = module {
    factory { createRetrofit().create(CharacterApi::class.java) }
    factory { createRetrofit().create(LocationApi::class.java) }
    factory { createRetrofit().create(EpisodeApi::class.java) }
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