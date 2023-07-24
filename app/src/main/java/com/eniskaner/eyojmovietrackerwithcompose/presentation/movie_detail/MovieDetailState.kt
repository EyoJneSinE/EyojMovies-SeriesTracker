package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail

import com.eniskaner.eyojmovietrackerwithcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : List<MovieDetail> = emptyList(),
    val error : String = ""
)