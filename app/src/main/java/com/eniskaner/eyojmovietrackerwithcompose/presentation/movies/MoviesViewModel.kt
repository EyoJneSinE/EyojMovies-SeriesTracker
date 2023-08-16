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
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {


    private val _stateFromTMDB = mutableStateOf<MoviesState>(MoviesState())
    val stateFromTMDB : State<MoviesState> = _stateFromTMDB

    private var job : Job? = null

    init {
        getSearchMoviesFromTMDB(_stateFromTMDB.value.search)
        getMoviesFromTMBD()
    }
    private fun getMoviesFromTMBD() {
        job?.cancel()
        job = getMoviesUseCase.executeGetMoviesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _stateFromTMDB.value = MoviesState(movies = it.data?.movies ?: emptyList())
                }

                is Resource.Error -> {
                    _stateFromTMDB.value = MoviesState(error = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _stateFromTMDB.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSearchMoviesFromTMDB(search: String) {
        job?.cancel()
        job = getMoviesUseCase.executeSearchMovieFromTMDB(search).onEach {
            when (it) {
                is Resource.Success -> {
                    _stateFromTMDB.value = MoviesState(movies = it.data?.movies ?: emptyList())
                }

                is Resource.Error -> {
                    _stateFromTMDB.value = MoviesState(error = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _stateFromTMDB.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getNowPlayingMoviesFromTMDB() {
        job?.cancel()
        job = getMoviesUseCase.executeGetNowPlayingMoviesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _stateFromTMDB.value = MoviesState(movies = it.data?.movies ?: emptyList())
                }

                is Resource.Error -> {
                    _stateFromTMDB.value = MoviesState(error = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _stateFromTMDB.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event : MoviesEvent) {
        when(event) {
            is MoviesEvent.SearchMovies -> {
                getSearchMoviesFromTMDB(event.searchMovies)
            }
        }
    }

}