package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class ProductionCountryDto(
    @SerializedName("iso_3166_1")
    val iso31661: String?, // US
    @SerializedName("name")
    val name: String? // United States of America
)