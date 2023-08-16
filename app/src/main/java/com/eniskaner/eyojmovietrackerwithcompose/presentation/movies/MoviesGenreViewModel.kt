package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojmovietrackerwithcompose.domain.movies_usecase.GetMoviesUseCase
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesGenreViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {
    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state : State<MoviesState> = _state

    private var jobMovieGenres : Job? = null

    init {
        getGenreMoviesFromTMDB()
    }

    private fun getGenreMoviesFromTMDB() {
        jobMovieGenres?.cancel()
        jobMovieGenres = getMoviesUseCase.executeGenreMoviesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MoviesState(moviesGenre = it.data?.genres ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MoviesState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}