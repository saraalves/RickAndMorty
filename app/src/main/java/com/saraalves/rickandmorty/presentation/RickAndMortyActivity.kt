package com.saraalves.rickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saraalves.rickandmorty.ViewPagerAdapter
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ActivityRickAndMortyBinding
import com.saraalves.rickandmorty.presentation.character.fragment.CharacterFragment
import com.saraalves.rickandmorty.presentation.episodes.EpisodesFragment
import com.saraalves.rickandmorty.presentation.location.LocationFragment

class RickAndMortyActivity : AppCompatActivity(R.layout.activity_rick_and_morty) {

    private val binding by lazy { ActivityRickAndMortyBinding.inflate(layoutInflater) }

    private val tabLayout by lazy { binding.tabLayout }

    private lateinit var characterFragment: CharacterFragment
    private lateinit var locationFragment: LocationFragment
    private lateinit var episodeFragment: EpisodesFragment

    private val _tabTitle = listOf(
        "Personagens",
        "Localização",
        "Episódios",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configViewPager()
        setupTabIcons()
    }

    private fun configViewPager() {

        tabLayout.setupWithViewPager(binding.viewPager)

        characterFragment = CharacterFragment()
        locationFragment = LocationFragment()
        episodeFragment = EpisodesFragment()

        val listaFragmentos = listOf(
            characterFragment,
            locationFragment,
            episodeFragment
        )

        binding.viewPager.adapter = ViewPagerAdapter(listaFragmentos, supportFragmentManager)

    }

    private fun setupTabIcons() {
        tabLayout.getTabAt(0)?.text = _tabTitle[0]
        tabLayout.getTabAt(1)?.text = _tabTitle[1]
        tabLayout.getTabAt(2)?.text = _tabTitle[2]
    }
}