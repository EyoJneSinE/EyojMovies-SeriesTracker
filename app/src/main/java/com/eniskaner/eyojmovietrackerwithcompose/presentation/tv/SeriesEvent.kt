package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv

sealed class SeriesEvent {
    data class SearchSeries(val searchSeries: String) : SeriesEvent()
}