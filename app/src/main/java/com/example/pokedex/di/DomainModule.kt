package com.example.pokedex.di

import com.example.pokedex.domain.interactor.GetSinglePokemonUseCase
import org.koin.dsl.module

fun domainModule() = module {
    factory { GetSinglePokemonUseCase(get()) }
}