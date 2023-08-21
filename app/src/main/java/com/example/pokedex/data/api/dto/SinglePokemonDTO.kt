package com.example.pokedex.data.api.dto

import com.example.pokedex.data.api.dto.SlotTypeDTO
import com.example.pokedex.data.api.dto.SpritesDTO
import com.google.gson.annotations.SerializedName

data class SinglePokemonDTO(
    @SerializedName("name") val name: String? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("weight") val weight: Int? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("sprites") val sprites: SpritesDTO,
    @SerializedName("types") val types: List<SlotTypeDTO>
)
