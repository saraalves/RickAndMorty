package com.saraalves.rickandmorty.presentation.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.presentation.ui.theme.DetailsScreen

class DetailsActivity : ComponentActivity() {

//    private val character: SingleCharacter = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val image = intent.extras?.getString("image").orEmpty()
        val name = intent.extras?.getString("name").orEmpty()
        val status = intent.extras?.getString("status").orEmpty()

        setContent {
            DetailsScreen(image, name, status)
        }
    }
}