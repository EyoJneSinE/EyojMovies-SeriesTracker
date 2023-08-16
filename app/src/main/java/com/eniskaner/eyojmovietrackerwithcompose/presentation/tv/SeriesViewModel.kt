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
class SeriesViewModel @Inject constructor(
    private val getSeriesUseCase: GetSeriesUseCase
): ViewModel() {
    private val _state = mutableStateOf<SeriesState>(SeriesState())
    val state : State<SeriesState> = _state

    private var job : Job? = null
    private var jobGenres : Job? = null

    init {
        getSearchSeries(_state.value.search)
        getSeriesFromTMBD()
    }


    private fun getSearchSeries(search: String) {
        job?.cancel()
        job = getSeriesUseCase.executeSearchSerieFromTMDB(search).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = SeriesState(series = it.data ?: null)
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
    private fun getSeriesFromTMBD() {
        job?.cancel()
        job = getSeriesUseCase.executeGetSeriesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = SeriesState(series = it.data ?: null )
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

    private fun getTopRatedSeriesFromTMDB() {
        job?.cancel()
        job = getSeriesUseCase.executeGetTopRatedSeriesFromTMDB().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = SeriesState(series = it.data ?: null)
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

    fun onEvent(event : SeriesEvent) {
        when(event) {
            is SeriesEvent.SearchSeries -> {
                getSearchSeries(event.searchSeries)
            }
        }
    }
}