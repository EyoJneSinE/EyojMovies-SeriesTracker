package com.eniskaner.eyojmovietrackerwithcompose.domain.usecase

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.toMovieList
import com.eniskaner.eyojmovietrackerwithcompose.domain.model.Movie
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "Movie can't found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "internet connection error!!!"))
        }
    }
}