package com.example.pokedex.domain.repository

import androidx.paging.PagingData
import com.example.pokedex.domain.models.SinglePokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getSinglePokemon(): Flow<PagingData<SinglePokemon>>
}