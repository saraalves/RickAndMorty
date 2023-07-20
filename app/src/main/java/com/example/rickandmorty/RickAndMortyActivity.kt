package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.ActivityRickAndMortyBinding

class RickAndMortyActivity : AppCompatActivity(R.layout.activity_rick_and_morty) {

    private val binding by lazy { ActivityRickAndMortyBinding.inflate(layoutInflater) }

    private val tabLayout by lazy { binding.tabLayout }

    private lateinit var characterFragment: CharacterFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var episodeFragment: EpisodeFragment

    private val _tabIcons = intArrayOf(
        R.drawable.baseline_home_24,
        R.drawable.baseline_person_24,
        R.drawable.baseline_rocket_24,
        R.drawable.baseline_vpn_lock_24
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
            characterFragment,
            characterFragment
        )

        binding.viewPager.adapter = ViewPagerAdapter(listaFragmentos, supportFragmentManager)

    }

    private fun setupTabIcons() {
        tabLayout.getTabAt(0)?.setIcon(_tabIcons[0])
        tabLayout.getTabAt(1)?.setIcon(_tabIcons[1])
        tabLayout.getTabAt(2)?.setIcon(_tabIcons[2])
        tabLayout.getTabAt(3)?.setIcon(_tabIcons[3])
        tabLayout.getTabAt(4)?.setIcon(_tabIcons[4])
    }
}