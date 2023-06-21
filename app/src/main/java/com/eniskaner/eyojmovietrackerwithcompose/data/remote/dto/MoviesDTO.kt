package com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto

data class MoviesDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)