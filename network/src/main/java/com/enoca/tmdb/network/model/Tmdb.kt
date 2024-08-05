package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class Tmdb(
    @SerializedName("avatar_path")
    val avatarPath: Any? // null
)