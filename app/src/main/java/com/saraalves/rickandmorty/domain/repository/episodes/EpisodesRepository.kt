package com.saraalves.rickandmorty.domain.repository.episodes

import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {

    fun getAllEpisodes(page: Int): Flow<AllEpisodes>
    fun getEpisode(id: Int): Flow<List<SingleEpisode>>
    fun getAllEpisodesData(page: Int): Flow<AllEpisodes>
}