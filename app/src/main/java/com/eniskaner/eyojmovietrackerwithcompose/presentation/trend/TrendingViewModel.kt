package com.eniskaner.eyojmovietrackerwithcompose.presentation.trend

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojmovietrackerwithcompose.domain.movies_usecase.GetMoviesUseCase
import com.eniskaner.eyojmovietrackerwithcompose.domain.series_usecase.GetSeriesUseCase
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getSeriesUseCase: GetSeriesUseCase
) : ViewModel() {



    private val _movieState = mutableStateOf<TrendingState>(TrendingState())
    val movieState : State<TrendingState> = _movieState

    private val _serieState = mutableStateOf<TrendingState>(TrendingState())
    val serieState : State<TrendingState> = _serieState

    private var jobMovies : Job? = null
    private var jobSeries : Job? = null

    init {
        getTrendingMovies()
        getTrendingSeries()
    }

    private fun getTrendingMovies() {
        jobMovies?.cancel()
        jobMovies = getMoviesUseCase.executeGetMoviesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _movieState.value = TrendingState(movies = it.data?.movies ?: emptyList())
                }
                is Resource.Error -> {
                    _movieState.value = TrendingState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _movieState.value = TrendingState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getTrendingSeries() {
        jobSeries?.cancel()
        jobSeries = getSeriesUseCase.executeGetTopRatedSeriesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _serieState.value = TrendingState(series = it.data?.series ?: emptyList())
                }
                is Resource.Error -> {
                    _serieState.value = TrendingState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _serieState.value = TrendingState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}