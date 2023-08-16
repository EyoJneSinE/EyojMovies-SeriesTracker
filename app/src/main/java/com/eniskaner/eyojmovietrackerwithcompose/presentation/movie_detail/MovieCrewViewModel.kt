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
class MovieCrewViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val savedCrewStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    private var jobCrews : Job? = null

    init {
        savedCrewStateHandle.get<String>(MOVIE_ID.toString())?.let {
            getMovieCrewFromTMDB(it.toInt())
        }
    }

    private fun getMovieCrewFromTMDB(imdbId: Int) {
        jobCrews?.cancel()
        jobCrews = getMovieDetailUseCase.executeGetCastFromTMDB(imdbId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(crew = it.data?.crew ?: emptyList())
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