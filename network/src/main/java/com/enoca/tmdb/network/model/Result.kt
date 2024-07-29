package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("adult")
    val adult: Boolean?, // false
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /tncbMvfV0V07UZozXdBEq4Wu9HH.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Int?>?,
    @SerializedName("id")
    val id: Int?, // 573435
    @SerializedName("original_language")
    val originalLanguage: String?, // en
    @SerializedName("original_title")
    val originalTitle: String?, // Bad Boys: Ride or Die
    @SerializedName("overview")
    val overview: String?, // After their late former Captain is framed, Lowrey and Burnett try to clear his name, only to end up on the run themselves.
    @SerializedName("popularity")
    val popularity: Double?, // 9457.863
    @SerializedName("poster_path")
    val posterPath: String?, // /nP6RliHjxsz4irTKsxe8FRhKZYl.jpg
    @SerializedName("release_date")
    val releaseDate: String?, // 2024-06-05
    @SerializedName("title")
    val title: String?, // Bad Boys: Ride or Die
    @SerializedName("video")
    val video: Boolean?, // false
    @SerializedName("vote_average")
    val voteAverage: Double?, // 7.628
    @SerializedName("vote_count")
    val voteCount: Int? // 1067
)