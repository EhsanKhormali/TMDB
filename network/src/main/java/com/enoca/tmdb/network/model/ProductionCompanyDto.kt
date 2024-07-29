package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class ProductionCompanyDto(
    @SerializedName("id")
    val id: Int?, // 122771
    @SerializedName("logo_path")
    val logoPath: String?, // /bYRqVEAuaC1QWmt3hGo0PMdK7EX.png
    @SerializedName("name")
    val name: String?, // Westbrook
    @SerializedName("origin_country")
    val originCountry: String? // US
)