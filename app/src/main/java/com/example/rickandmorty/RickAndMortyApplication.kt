package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            networkModule
        )

        startKoin{
            androidContext(this@RickAndMortyApplication)
            modules(allModules)
        }
    }
}