package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saraalves.rickandmorty.R

class RickAndMortyActivity : AppCompatActivity(R.layout.activity_rick_and_morty) {

    private val binding by lazy {
        RickAndMortyActivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rick_and_morty)
    }
}