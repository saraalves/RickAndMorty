package com.saraalves.rickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saraalves.rickandmorty.ViewPagerAdapter
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ActivityRickAndMortyBinding

class RickAndMortyActivity : AppCompatActivity(R.layout.activity_rick_and_morty) {

    private val binding by lazy { ActivityRickAndMortyBinding.inflate(layoutInflater) }

    private val tabLayout by lazy { binding.tabLayout }

    private lateinit var characterFragment: CharacterFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var episodeFragment: EpisodeFragment

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
        profileFragment = ProfileFragment()
        episodeFragment = EpisodeFragment()

        val listaFragmentos = listOf(
            characterFragment,
            profileFragment,
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