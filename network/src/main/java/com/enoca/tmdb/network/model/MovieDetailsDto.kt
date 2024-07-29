package com.enoca.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class MovieDetailsDto(
    @SerializedName("adult")
    val adult: Boolean?, // false
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /tncbMvfV0V07UZozXdBEq4Wu9HH.jpg
    @SerializedName("belongs_to_collection")
    val movieCollectionDto: MovieCollectionDto?,
    @SerializedName("budget")
    val budget: Int?, // 100000000
    @SerializedName("genres")
    val genres: List<GenreDto?>?,
    @SerializedName("homepage")
    val homepage: String?, // https://www.badboys.movie
    @SerializedName("id")
    val id: Int, // 573435
    @SerializedName("imdb_id")
    val imdbId: String?, // tt4919268
    @SerializedName("origin_country")
    val originCountry: List<String?>?,
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
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto?>?,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto?>?,
    @SerializedName("release_date")
    val releaseDate: String?, // 2024-06-05
    @SerializedName("revenue")
    val revenue: Int?, // 388242778
    @SerializedName("runtime")
    val runtime: Int?, // 115
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto?>?,
    @SerializedName("status")
    val status: String?, // Released
    @SerializedName("tagline")
    val tagline: String?, // Miami's finest are now its most wanted.
    @SerializedName("title")
    val title: String?, // Bad Boys: Ride or Die
    @SerializedName("video")
    val video: Boolean?, // false
    @SerializedName("vote_average")
    val voteAverage: Double?, // 7.648
    @SerializedName("vote_count")
    val voteCount: Int? // 1078
)