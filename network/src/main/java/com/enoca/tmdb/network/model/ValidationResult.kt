package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class ValidationResult(
    @SerializedName("status_code")
    val statusCode: Int?, // 1
    @SerializedName("status_message")
    val statusMessage: String?, // Success.
    @SerializedName("success")
    val success: Boolean? // true
)