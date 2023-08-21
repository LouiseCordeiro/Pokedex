package com.example.pokedex.di

import com.example.pokedex.presentation.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun presentationModule() = module {
    viewModel { PokedexViewModel(get()) }
}