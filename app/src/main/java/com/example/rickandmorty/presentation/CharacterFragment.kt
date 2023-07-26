package com.example.rickandmorty.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmorty.domain.model.response.AllCharacters
import com.example.rickandmorty.presentation.adapter.character.AllCharactersAdapter
import com.example.rickandmorty.presentation.viewmodel.CharacterViewModel
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.FragmentCharacterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding

    private lateinit var adapter: AllCharactersAdapter
    private var allCharacter = mutableListOf<AllCharacters>()
    private val viewModel: CharacterViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

}