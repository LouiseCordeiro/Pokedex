package com.example.pokedex.domain.interactor

import com.example.pokedex.domain.repository.PokemonRepository

class GetSinglePokemonUseCase(private val repository: PokemonRepository) {

    fun execute() = repository.getSinglePokemon()
}