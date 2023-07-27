package com.saraalves.rickandmorty.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.saraalves.rickandmorty.domain.model.response.AllCharacters
import com.saraalves.rickandmorty.presentation.adapter.character.AllCharactersAdapter
import com.saraalves.rickandmorty.presentation.viewmodel.CharacterViewModel
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
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setupRecyclerView()
        viewModel.getAllCharacters()
    }

    private fun setupRecyclerView() {

        adapter = AllCharactersAdapter { character ->
            character.let {}

        }
        adapter.apply {
            binding?.recyclerView?.adapter = adapter
            binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
            binding?.characterListProgressBar?.isVisible = true
        }
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding?.characterListProgressBar?.visibility = View.VISIBLE
            } else {
                binding?.characterListProgressBar?.visibility = View.GONE
            }
        }

        viewModel.characters.observe(viewLifecycleOwner) { character ->
            binding?.characterListProgressBar?.isVisible = false
            adapter.submitList(character)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding?.let {
                it.characterListProgressBar.isVisible = false
                it.recyclerView.isVisible = false
                // colocar cenario de erro
            }
        }
    }


}