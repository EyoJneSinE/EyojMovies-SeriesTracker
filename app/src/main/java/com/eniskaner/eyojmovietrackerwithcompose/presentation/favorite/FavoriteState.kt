package com.eniskaner.eyojmovietrackerwithcompose.presentation.favorite

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies.MoviesResult
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.top_rated_series.SeriesResult

data class FavoriteState(
    val isLoading: Boolean = false,
    val movies: List<MoviesResult> = emptyList(),
    val error: String = "",
    val series: List<SeriesResult> = emptyList(),
)
