package com.eniskaner.eyojmovietrackerwithcompose.presentation.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.eniskaner.eyojmovietrackerwithcompose.domain.movies_usecase.GetMoviesUseCase
import com.eniskaner.eyojmovietrackerwithcompose.domain.series_usecase.GetSeriesUseCase
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesEvent
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesState
import kotlinx.coroutines.Job
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getSeriesUseCase: GetSeriesUseCase
) : ViewModel() {



    private val _state = mutableStateOf<FavoriteState>(FavoriteState())
    val state : State<FavoriteState> = _state

    private val _stateFromTMDB = mutableStateOf<MoviesState>(MoviesState())
    val stateFromTMDB : State<MoviesState> = _stateFromTMDB

    private var job : Job? = null

    init {
    }

    private fun getFavoriteMovies() {
        job?.cancel()

    }
    private fun getMoviesFromTMBD() {
        job?.cancel()

    }

    private fun getNowPlayingMoviesFromTMDB() {
        job?.cancel()
    }

    fun onEvent(event : MoviesEvent) {

    }

}