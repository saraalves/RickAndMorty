package com.example.rickandmorty.data.mapper

interface Mapper<S, T> {
    fun map(source: S): T
}