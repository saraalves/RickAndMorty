package com.saraalves.rickandmorty.presentation.character.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.presentation.ui.theme.colorPrimaryDark

@Composable
fun ErrorComposable(onClickAction: () -> Unit) {

    Box(
        modifier = Modifier
            .background(colorPrimaryDark)
            .fillMaxSize()
    ) {
        Column {
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

                    Text(
                        text = "Opa erramos por aqui",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 20.sp

                    )
                    Text(
                        text = "Tivemos alguma falha no sistema. Tente novamente mais tarde.",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 20.sp
                    )
                    AuthenticationButton(onClickAction)
                }
            }
        }
    }
}


@Composable
fun AuthenticationButton(onClickAction: () -> Unit) {
    Button(onClick = onClickAction, colors = ButtonDefaults.textButtonColors(containerColor = Color.LightGray)) {
        Text(text = "Tentar novamente")
    }
}