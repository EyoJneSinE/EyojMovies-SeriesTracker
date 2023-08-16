package com.eniskaner.eyojmovietrackerwithcompose.domain.movies_usecase

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies.GetMovieFromId
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_genre.GenresFromTMDB
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
    fun executeGetMoviesFromTMDB() : Flow<Resource<GetMovieFromId>> = flow {
        try {
            emit(Resource.Loading())
            val movieListFromTMDB = repository.getMoviesFromTMDB()
            if (movieListFromTMDB.movies.isNotEmpty()) {
                emit(Resource.Success(movieListFromTMDB))
            } else {
                emit(Resource.Error(message = "Movie Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }

    fun executeSearchMovieFromTMDB(search: String) : Flow<Resource<GetMovieFromId>> = flow {
        try {
            emit(Resource.Loading())
            val searchListFromTMDB = repository.searchMovieFromTMDB(search)
            if (searchListFromTMDB.movies.isNotEmpty()) {
                emit(Resource.Success(searchListFromTMDB))
            } else {
                emit(Resource.Error(message = "Searching Movie Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }

    fun executeGetNowPlayingMoviesFromTMDB() : Flow<Resource<GetMovieFromId>> = flow {
        try {
            emit(Resource.Loading())
            val nowPlayingListFromTMDB = repository.getNowPlayingMoviesFromTMDB()
            if (nowPlayingListFromTMDB.movies.isNotEmpty()) {
                emit(Resource.Success(nowPlayingListFromTMDB))
            } else {
                emit(Resource.Error(message = "Now Playing Movies Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGenreMoviesFromTMDB() : Flow<Resource<GenresFromTMDB>> = flow {
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
}