package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies

sealed class MoviesEvent {
    data class SearchMovies(val searchMovies: String) : MoviesEvent()
}
