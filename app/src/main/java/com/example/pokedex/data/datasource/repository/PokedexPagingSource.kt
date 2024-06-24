package com.example.pokedex.data.datasource.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.data.api.PokemonApi
import com.example.pokedex.util.Constants.LAST_OFFSET
import com.example.pokedex.util.Constants.LAST_POSITION
import com.example.pokedex.util.Constants.POKEMON_OFFSET
import com.example.pokedex.util.Constants.POKEMON_STARTING_OFFSET
import com.example.pokedex.data.mapper.toModel
import com.example.pokedex.domain.models.SinglePokemon
import retrofit2.HttpException
import java.io.IOException

class PokedexPagingSource(
    private val api: PokemonApi
) : PagingSource<Int, SinglePokemon>() {

    override fun getRefreshKey(state: PagingState<Int, SinglePokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SinglePokemon> {
        val position = params.key ?: POKEMON_STARTING_OFFSET
        return try {
            val response = api.getPokemon(
                if (position == LAST_POSITION) {
                    LAST_OFFSET
                } else {
                    position * POKEMON_OFFSET
                }
            )
            val pokemon = mutableListOf<SinglePokemon>()
            response.body()?.results?.map { result ->
                val singlePokemon = api.getSinglePokemon(result.name)
                singlePokemon.body()?.toModel()?.let { pokemon.add(it) }
            }
            LoadResult.Page(
                data = pokemon,
                prevKey = if (position == POKEMON_STARTING_OFFSET) null else position,
                nextKey = if (position == LAST_POSITION) null else position + 1
            )
        } catch (exception: IOException) {
            throw RuntimeException(exception)
        } catch (exception: HttpException) {
            throw RuntimeException(exception)
        }
    }
}