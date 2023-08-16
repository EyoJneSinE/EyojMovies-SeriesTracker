package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojmovietrackerwithcompose.domain.series_usecase.GetSeriesDetailUseCase
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.SERIES_ID
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SeriesCastViewModel @Inject constructor(
    private val getSeriesDetailUseCase: GetSeriesDetailUseCase,
    private val savedCastStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<SeriesDetailState>(SeriesDetailState())
    val state : State<SeriesDetailState> = _state

    private var jobCasts : Job? = null

    init {
        savedCastStateHandle.get<String>(SERIES_ID.toString())?.let {
            getSeriesCastFromTMDB(it.toInt())
        }
    }

    private fun getSeriesCastFromTMDB(seriesId: Int) {
        jobCasts?.cancel()
        jobCasts = getSeriesDetailUseCase.executeGetSeriesCastFromTMDB(seriesId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = SeriesDetailState(cast = it.data)
                }
                is Resource.Error -> {
                    _state.value = SeriesDetailState(error = it.message ?: "Error!")
                }
                is Resource.Loading -> {
                    _state.value = SeriesDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}