package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class MovieCollectionDto(
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /k9hhSHg5GS4UgWQC6MHBOZrarji.jpg
    @SerializedName("id")
    val id: Int?, // 14890
    @SerializedName("name")
    val name: String?, // Bad Boys Collection
    @SerializedName("poster_path")
    val posterPath: String? // /iB59poJBofg1ciKlu6LzZakf11m.jpg
)