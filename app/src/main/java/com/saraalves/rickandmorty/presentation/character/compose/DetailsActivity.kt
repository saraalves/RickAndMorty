package com.saraalves.rickandmorty.presentation.character.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalMaterial3Api::class)
class DetailsActivity : ComponentActivity() {

    // colocar dark mode
    // casos de erro e loading
    //ajustar a toolbar

    private val viewModel: CharacterDetailViewModel by viewModel()
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = intent.extras?.getInt("id") ?: 0
        observeViewModel()
        viewModel.getSingleCharacter(id)

    }

    private fun observeViewModel() {
        viewModel.singleCharacterState.observe(this) { state ->
            state.characterData?.let { character ->
                setContent {
                    Scaffold(topBar = {
                        Header(
                            name = character.name ?: "",
                            onBackPressed = { onBackPressedDispatcher.onBackPressed() })
                    }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            DetailActivityComposable(
                                character.name ?: "",
                                character.image ?: "",
                                character.status ?: ""
                            )
                        }
                    }
                }
            }
            if (state.isLoading) {
                setContent {
                    LoadingComposable()
                }
            }
            state.isError?.let {
                setContent {
                    ErrorComposable { viewModel.getSingleCharacter(id) }
                }
            }
        }
    }

}
}
