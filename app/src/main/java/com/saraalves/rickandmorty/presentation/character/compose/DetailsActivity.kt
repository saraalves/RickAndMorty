package com.saraalves.rickandmorty.presentation.character.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : ComponentActivity() {

    // colocar dark mode
    // casos de erro e loading

    private val viewModel: CharacterDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.extras?.getInt("id") ?: 0
        observeViewModel()
        viewModel.getSingleCharacter(id)

    }

    private fun observeViewModel() {
        viewModel.singleCharacterState.observe(this) { state ->
            state.characterData?.let {
                setContent {
                    Surface {
                        RickAndMortyTheme {
                            DetailActivityComposable(it.name ?: "", it.image ?: "", it.status ?: "")
                        }
                    }
                }
            }

        }
    }

}