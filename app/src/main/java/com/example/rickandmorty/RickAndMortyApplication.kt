package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.di.characterUseCaseModule
import com.example.rickandmorty.di.chracterViewModel
import com.example.rickandmorty.di.dataSourceModule
import com.example.rickandmorty.di.mapperModule
import com.example.rickandmorty.di.networkModule
import com.example.rickandmorty.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            networkModule,
            chracterViewModel,
            characterUseCaseModule,
            mapperModule,
            dataSourceModule,
            repositoryModule
        )

        startKoin{
            androidContext(this@RickAndMortyApplication)
            modules(allModules)
        }
    }
}