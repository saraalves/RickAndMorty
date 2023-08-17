package com.saraalves.rickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ActivityRickAndMortyBinding
import com.saraalves.rickandmorty.presentation.character.fragment.CharacterFragment
import com.saraalves.rickandmorty.presentation.episodes.EpisodesFragment
import com.saraalves.rickandmorty.presentation.location.LocationFragment

class RickAndMortyActivity : AppCompatActivity(R.layout.activity_rick_and_morty) {

    private val binding by lazy { ActivityRickAndMortyBinding.inflate(layoutInflater) }

    lateinit var bottomNav : BottomNavigationView

    private lateinit var characterFragment: CharacterFragment
    private lateinit var locationFragment: LocationFragment
    private lateinit var episodeFragment: EpisodesFragment

    // alterar de viewPager para bottom navigation
    private val _tabTitle = listOf(
        "Personagens",
        "Localização",
        "Episódios",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFragment(CharacterFragment())
        bottomNav = binding.bottomNav
        bottomNav.setOnItemReselectedListener {
            when(it.itemId) {
                R.id.character -> {
                    loadFragment(CharacterFragment())
                }
                R.id.location -> {
                    loadFragment(LocationFragment())
                }
                R.id.episodes -> {
                    loadFragment(EpisodesFragment())
                }
            }
        }


    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

}