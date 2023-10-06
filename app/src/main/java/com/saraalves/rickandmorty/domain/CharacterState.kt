package com.saraalves.rickandmorty.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.saraalves.rickandmorty.UIState
import com.saraalves.rickandmorty.domain.model.response.character.SingleCharacter

data class CharacterState(
    val characterData: SingleCharacter? = null,
    val isError: StateError? = null,
    val isLoading: Boolean = false,
)