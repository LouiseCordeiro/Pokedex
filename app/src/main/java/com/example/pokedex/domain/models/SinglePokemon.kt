package com.example.pokedex.domain.models

data class SinglePokemon(
    val name: String,
    val id: Int,
    val imageUrl: String,
    val types: List<Type>
)
