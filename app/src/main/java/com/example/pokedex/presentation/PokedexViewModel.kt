package com.example.pokedex.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokedex.domain.models.SinglePokemon
import com.example.pokedex.domain.interactor.GetSinglePokemonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val MIN_POKEMON_ID = 1
private const val MAX_POKEMON_ID = 151

class PokedexViewModel(private val useCase: GetSinglePokemonUseCase) : ViewModel() {

    fun getPokemonFlow(): Flow<PagingData<SinglePokemon>> {
        return useCase.execute().cachedIn(viewModelScope)
    }

}