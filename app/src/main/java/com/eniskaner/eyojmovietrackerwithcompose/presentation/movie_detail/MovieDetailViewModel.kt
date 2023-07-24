package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail

import androidx.lifecycle.ViewModel
import com.eniskaner.eyojmovietrackerwithcompose.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {
}