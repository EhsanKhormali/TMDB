package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("page")
    val page: Int?, // 1
    @SerializedName("results")
    val results: List<MovieDto>?,
    @SerializedName("total_pages")
    val totalPages: Int?, // 45396
    @SerializedName("total_results")
    val totalResults: Int? // 907918
)