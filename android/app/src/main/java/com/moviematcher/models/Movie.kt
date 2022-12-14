package com.moviematcher.models

data class Movie(
    val genres: List<String>,
    val id: Double,
    val overview: String,
    val title: String,
    val posterPath: String,
    val isInMyList: Boolean,
    val isRecommended: Boolean
)