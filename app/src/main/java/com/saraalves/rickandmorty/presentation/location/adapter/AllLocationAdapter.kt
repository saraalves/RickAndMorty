package com.saraalves.rickandmorty.presentation.location.adapter

import androidx.recyclerview.widget.ListAdapter
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation
import com.saraalves.rickandmorty.presentation.DefaultDiffCallback

class AllLocationAdapter(
    private val clickListener: (SingleLocation) -> Unit
) : ListAdapter<SingleLocation, AllLocationViewHolder>(DefaultDiffCallback<SingleLocation>()){
}