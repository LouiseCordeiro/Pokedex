package com.example.pokedex.presentation

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.databinding.PokemonCardBinding
import com.example.pokedex.domain.models.SinglePokemon
import com.example.pokedex.util.showIf

class PokemonViewHolder(
    binding: PokemonCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val image = binding.pokemonImage
    private val name = binding.pokemonName
    private val id = binding.pokemonId
    private val firstType = binding.firstPokemonType
    private val secondType = binding.secondPokemonType

    fun bind(singlePokemon: SinglePokemon) {
        loadPokemonImage(image, singlePokemon.imageUrl)
        name.text = singlePokemon.name
        id.text = singlePokemon.id.toString()
        firstType.text = singlePokemon.types.first().name
        secondType.text = singlePokemon.types.last().name
        secondType.apply {
            showIf(text.isNotEmpty())
        }
    }

    private fun loadPokemonImage(image: ImageView, imageUrl: String) {
        image.load(imageUrl)
    }
}