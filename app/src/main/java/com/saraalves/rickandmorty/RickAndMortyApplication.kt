package com.saraalves.rickandmorty

import android.app.Application
import com.saraalves.rickandmorty.di.dataSourceModule
import com.saraalves.rickandmorty.di.mapperModule
import com.saraalves.rickandmorty.di.networkModule
import com.saraalves.rickandmorty.di.repositoryModule
import com.saraalves.rickandmorty.di.useCaseModule
import com.saraalves.rickandmorty.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            networkModule,
            viewModelModule,
            useCaseModule,
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