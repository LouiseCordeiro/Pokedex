package com.example.pokedex.data.mapper

import com.example.pokedex.data.api.dto.OfficialArtWorkDTO
import com.example.pokedex.data.api.dto.SinglePokemonDTO
import com.example.pokedex.data.api.dto.SlotTypeDTO
import com.example.pokedex.domain.models.SinglePokemon
import com.example.pokedex.domain.models.Type
import com.example.pokedex.util.emptyString
import com.example.pokedex.util.zeroNumber

fun SlotTypeDTO.toModel() = Type(
    name = typeDTO.name ?: emptyString()
)

fun List<SlotTypeDTO>.toModel(): List<Type> {
    val types = mutableListOf<Type>()
    types.add(this.first().toModel())
    this.first().let { firstType ->
        this.last().let { secondType ->
            if(secondType != firstType) {
                types.add(secondType.toModel())
            } else {
                types.add(Type(emptyString()))
            }
        }
    }
    return types.toList()
}

fun SinglePokemonDTO.toModel() = SinglePokemon(
    name = name ?: emptyString(),
    id = id ?: zeroNumber(),
    imageUrl = sprites.other.officialArtworkDTO.frontDefault ?: emptyString(),
    types = types.toModel()
)