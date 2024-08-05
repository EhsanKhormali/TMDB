package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class Gravatar(
    @SerializedName("hash")
    val hash: String? // 0ec95505b5f640a3edbdcb1923d169ed
)