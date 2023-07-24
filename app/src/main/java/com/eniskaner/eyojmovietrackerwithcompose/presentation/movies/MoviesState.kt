package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies

import com.eniskaner.eyojmovietrackerwithcompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "marvel"
)
