package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString: String) : MoviesEvent()
}
