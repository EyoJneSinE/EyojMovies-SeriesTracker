package com.eniskaner.eyojmovietrackerwithcompose.domain.usecase

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.toMovieDetail
import com.eniskaner.eyojmovietrackerwithcompose.domain.model.MovieDetail
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun executeGetMovieDetails(imdbId : String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "internet connection error!!!"))
        }
    }
}