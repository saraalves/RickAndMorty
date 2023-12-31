package com.saraalves.rickandmorty.presentation.character.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.presentation.DefaultDiffCallback

class AllCharactersAdapter(
    private val clickListener: (SingleCharacter) -> Unit
) : ListAdapter<SingleCharacter, AllCharactersViewHolder>(DefaultDiffCallback<SingleCharacter>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCharactersViewHolder {
        return AllCharactersViewHolder.build(parent, clickListener)
    }

    override fun onBindViewHolder(holder: AllCharactersViewHolder, position: Int) {
        holder.bind(currentList[position] as SingleCharacter)
    }
}