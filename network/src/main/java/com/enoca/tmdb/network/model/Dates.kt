package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String?, // 2024-07-31
    @SerializedName("minimum")
    val minimum: String? // 2024-06-19
)