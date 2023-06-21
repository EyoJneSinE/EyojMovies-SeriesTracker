package com.eniskaner.eyojmovietrackerwithcompose.domain.repo

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.MovieDetailDTO
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.MoviesDTO

interface MovieRepository {

    suspend fun getMovies(search: String) : MoviesDTO

    suspend fun getMovieDetail(imdbId: String) : MovieDetailDTO
}