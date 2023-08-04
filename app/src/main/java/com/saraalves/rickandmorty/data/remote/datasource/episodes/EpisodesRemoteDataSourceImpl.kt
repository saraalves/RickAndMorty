package com.saraalves.rickandmorty.data.remote.datasource.episodes

import com.saraalves.rickandmorty.data.extensions.parseHttpError
import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.character.CharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.episodes.AllEpisodeResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.episodes.EpisodesResponseToModelMapper
import com.saraalves.rickandmorty.data.remote.api.RickAndMortyApi
import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EpisodesRemoteDataSourceImpl(
    private val episodesApi: RickAndMortyApi,
    private val allEpisodesMapper: AllEpisodeResponseToModelMapper,
    private val episodesMapper: EpisodesResponseToModelMapper
) : EpisodesRemoteDataSource {
    override fun getAllEpisodes(page: Int): Flow<AllEpisodes> {
        return flow { emit(allEpisodesMapper.map(episodesApi.getAllEpisode(page))) }.parseHttpError()
    }

    override fun getSingleEpisodes(id: Int): Flow<List<SingleEpisode>> {
        return flow { emit(episodesMapper.map(episodesApi.getSingleEpisode(id))) }.parseHttpError()
    }
}