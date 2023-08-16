package com.eniskaner.eyojmovietrackerwithcompose.domain.movies_usecase

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movie_details.GetMovieDetailsFromId
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_cast.CastingForMovieFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_genre.GenresFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_video.GetTrailerFromMovieId
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
    fun executeGetMovieDetailsFromTMDB(movieId: Int) : Flow<Resource<GetMovieDetailsFromId>> = flow {
        try {
            emit(Resource.Loading())
            val getMovieDetailsFromTMDB = repository.getMovieDetailsFromTMDB(movieId)
            if (getMovieDetailsFromTMDB.genres.isNotEmpty()) {
                emit(Resource.Success(getMovieDetailsFromTMDB))
            } else {
                emit(Resource.Error(message = "Movie Details Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGenreMovieFromTMDB() : Flow<Resource<GenresFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val genreListFromTMDB = repository.genreMovieFromTMDB()
            if (genreListFromTMDB.genres.isNotEmpty()) {
                emit(Resource.Success(genreListFromTMDB))
            } else {
                emit(Resource.Error(message = "Genres Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGetVideosFromTMDB(movieId: Int) : Flow<Resource<GetTrailerFromMovieId>> = flow {
        try {
            emit(Resource.Loading())
            val getTrailerFromTMDB = repository.getVideosFromTMDB(movieId)
            if (getTrailerFromTMDB.results.isNotEmpty()) {
                emit(Resource.Success(getTrailerFromTMDB))
            } else {
                emit(Resource.Error(message = "Trailers Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }

    fun executeGetCastFromTMDB(movieId: Int) : Flow<Resource<CastingForMovieFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val getCastFromTMDB = repository.getCastFromTMDB(movieId)
            if (getCastFromTMDB.cast.isNotEmpty()) {
                emit(Resource.Success(getCastFromTMDB))
            } else {
                emit(Resource.Error(message = "Cast Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
}