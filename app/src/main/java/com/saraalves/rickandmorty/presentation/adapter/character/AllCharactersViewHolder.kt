package com.saraalves.rickandmorty.presentation.adapter.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.saraalves.rickandmorty.domain.model.response.SingleCharacter
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ListItemCharacterBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class AllCharactersViewHolder(
    itemView: View, private val onItemClick: (SingleCharacter) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private var _binding: ListItemCharacterBinding? = null
    private val binding get() = _binding

    fun bind(characters: SingleCharacter) {
        binding?.root?.setOnClickListener { onItemClick(characters) }
        binding?.characterName?.text = characters.name
        binding?.text?.text = characters.status
        binding?.progressBar?.isVisible = false
        Picasso.get()
            .load(characters.image)
            .into(binding?.picture, object : Callback {
                override fun onSuccess() {
                    binding?.progressBar?.isVisible = false
                }

                override fun onError(e: Exception?) {
                    binding?.progressBar?.isVisible = false
                }
            })

    }

    companion object {
        fun build(parent: ViewGroup, onItemClick: (SingleCharacter) -> Unit): AllCharactersViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.list_item_character, parent, false)
            return AllCharactersViewHolder(view, onItemClick)
        }
    }
}