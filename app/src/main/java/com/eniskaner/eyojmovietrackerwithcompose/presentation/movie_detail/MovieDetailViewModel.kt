package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojmovietrackerwithcompose.domain.movies_usecase.GetMovieDetailUseCase
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.MOVIE_ID
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    private var jobMovies : Job? = null

    init {
        savedStateHandle.get<String>(MOVIE_ID.toString())?.let {
            getMovieDetailFromTMDB(it.toInt())
        }
    }

    private fun getMovieDetailFromTMDB(imdbId: Int) {
        jobMovies?.cancel()
        jobMovies = getMovieDetailUseCase.executeGetMovieDetailsFromTMDB(imdbId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getMovieGenreFromTMDB() {
        jobMovies?.cancel()
        jobMovies = getMovieDetailUseCase.executeGenreMovieFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(genre = it.data)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}