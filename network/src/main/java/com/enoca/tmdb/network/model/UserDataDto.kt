package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class UserDataDto(
    @SerializedName("avatar")
    val avatar: Avatar?,
    @SerializedName("id")
    val id: Int?, // 21405618
    @SerializedName("include_adult")
    val includeAdult: Boolean?, // false
    @SerializedName("iso_3166_1")
    val iso31661: String?, // TR
    @SerializedName("iso_639_1")
    val iso6391: String?, // en
    @SerializedName("name")
    val name: String?,
    @SerializedName("username")
    val username: String? // ehsankhormali
)