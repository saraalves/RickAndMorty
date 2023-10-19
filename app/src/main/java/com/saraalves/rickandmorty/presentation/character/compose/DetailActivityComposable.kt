package com.saraalves.rickandmorty.presentation.character.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterDetailViewModel
import com.saraalves.rickandmorty.presentation.ui.theme.colorPrimaryDark
import io.reactivex.Single

@Composable
fun DetailActivityComposable(
    name: String,
    image: String,
    status: String
) {

    Box(
        modifier = Modifier
            .background(colorPrimaryDark)
            .fillMaxSize()
    ) {
        Column {
            CharacterSection(image, status)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(name: String, onBackPressed: () -> Unit) {

    TopAppBar(title = {
        Text(text = name)
    },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(id = R.color.black),
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(
                onClick = { onBackPressed() },
                colors = IconButtonDefaults.iconButtonColors()
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Navigation icon",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun HeaderSection(
    name: String
) {
    Row(

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = name,
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Composable
fun CharacterSection(image: String?, status: String?) {
    Surface {
        Row(

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.colorPrimaryDark))
            ) {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Text(
                    text = status.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp

                )
                Text(
                    text = status.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp
                )
                Text(
                    text = status.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp
                )
            }
        }

    }
}