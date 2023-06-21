package com.eniskaner.eyojmovietrackerwithcompose.data.repo

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.MovieAPI
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.MovieDetailDTO
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.MoviesDTO
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplementation @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(search = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDTO {
        return api.getMovieDetail(imdbId = imdbId)
    }
}