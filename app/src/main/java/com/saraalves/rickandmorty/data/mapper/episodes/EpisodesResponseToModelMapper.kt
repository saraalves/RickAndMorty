package com.saraalves.rickandmorty.data.mapper.episodes

import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import com.saraalves.rickandmorty.data.extensions.mapper.mapToListResults
import com.saraalves.rickandmorty.data.mapper.Mapper
import com.saraalves.rickandmorty.data.remote.model.response.episodes.ResultsEpisodesResponse
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode

class EpisodesResponseToModelMapper : Mapper<List<ResultsEpisodesResponse>, List<SingleEpisode>> {
    override fun map(source: List<ResultsEpisodesResponse>): List<SingleEpisode> = source.map {
        SingleEpisode(
            id = it.id,
            name = it.name,
            airDate = it.airDate,
            episode = it.episode,
            characters = it.characters ?: emptyList(),
            url = it.url,
            created = it.created
        )
    }
}