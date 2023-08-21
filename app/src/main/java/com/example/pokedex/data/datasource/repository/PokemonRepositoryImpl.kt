package com.example.pokedex.data.datasource.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokedex.data.api.PokemonApi
import com.example.pokedex.util.Constants.PAGE_SIZE
import com.example.pokedex.data.datasource.repository.PokedexPagingSource
import com.example.pokedex.domain.models.SinglePokemon
import com.example.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonRepositoryImpl(private val api: PokemonApi) : PokemonRepository {

    override fun getSinglePokemon(): Flow<PagingData<SinglePokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE
            ),
            pagingSourceFactory = { PokedexPagingSource(api) }
        ).flow
    }
}
