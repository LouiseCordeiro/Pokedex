package com.example.pokedex.data.api.dto

import com.example.pokedex.data.api.dto.OtherDTO
import com.google.gson.annotations.SerializedName

data class SpritesDTO(
    @SerializedName("other") val other: OtherDTO
)
