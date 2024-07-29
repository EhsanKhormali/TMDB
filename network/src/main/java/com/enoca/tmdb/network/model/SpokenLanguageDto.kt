package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class SpokenLanguageDto(
    @SerializedName("english_name")
    val englishName: String?, // English
    @SerializedName("iso_639_1")
    val iso6391: String?, // en
    @SerializedName("name")
    val name: String? // English
)