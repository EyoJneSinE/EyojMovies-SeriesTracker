package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojmovietrackerwithcompose.domain.series_usecase.GetSeriesUseCase
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SeriesGenreViewModel @Inject constructor(
    private val getSeriesUseCase: GetSeriesUseCase
): ViewModel() {
    private val _state = mutableStateOf<SeriesState>(SeriesState())
    val state : State<SeriesState> = _state

    private var jobGenres : Job? = null

    init {
        getGenreSeriesFromTMDB()
    }

    private fun getGenreSeriesFromTMDB() {
        jobGenres?.cancel()
        jobGenres = getSeriesUseCase.executeGenreSeriesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = SeriesState(seriesGenre = it.data?.genres ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = SeriesState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = SeriesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}