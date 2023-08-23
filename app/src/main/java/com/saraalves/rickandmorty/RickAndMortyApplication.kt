package com.saraalves.rickandmorty

import android.app.Application
import com.saraalves.rickandmorty.di.networkModule
import com.saraalves.rickandmorty.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            networkModule,
            viewModelModule,
        )

        startKoin{
            androidContext(this@RickAndMortyApplication)
            modules(allModules)
        }
    }
}