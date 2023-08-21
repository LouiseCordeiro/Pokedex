package com.example.pokedex.data.api.dto

import com.example.pokedex.data.api.dto.OfficialArtWorkDTO
import com.google.gson.annotations.SerializedName

data class OtherDTO(
    @SerializedName("official-artwork") val officialArtworkDTO: OfficialArtWorkDTO
)
