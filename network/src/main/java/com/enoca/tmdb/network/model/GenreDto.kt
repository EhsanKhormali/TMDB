package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("id")
    val id: Int?, // 28
    @SerializedName("name")
    val name: String? // Action
)