package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies

import androidx.lifecycle.ViewModel
import com.eniskaner.eyojmovietrackerwithcompose.domain.usecase.GetMoviesUseCase
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
}