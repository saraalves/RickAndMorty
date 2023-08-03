package com.saraalves.rickandmorty.presentation.location.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saraalves.rickandmorty.domain.model.response.location.SingleLocation

class AllLocationViewHolder(itemView: View, private val onItemClick: (SingleLocation) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

        private val binding = ListItem
}