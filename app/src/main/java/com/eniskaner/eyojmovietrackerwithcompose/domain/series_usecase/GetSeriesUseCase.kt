package com.eniskaner.eyojmovietrackerwithcompose.domain.series_usecase

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_genre.SeriesGenreFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.top_rated_series.TopRatedTvFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetSeriesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun executeGetSeriesFromTMDB() : Flow<Resource<TopRatedTvFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val serieListFromTMDB = repository.getSeriesFromTMDB()
            if (serieListFromTMDB.series.isNotEmpty()) {
                emit(Resource.Success(serieListFromTMDB))
            } else {
                emit(Resource.Error(message = "Series Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }

    fun executeSearchSerieFromTMDB(search: String) : Flow<Resource<TopRatedTvFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val searchSeriesListFromTMDB = repository.searchSerieFromTMDB(search)
            if (searchSeriesListFromTMDB.series.isNotEmpty()) {
                emit(Resource.Success(searchSeriesListFromTMDB))
            } else {
                emit(Resource.Error(message = "Searching Series Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGetTopRatedSeriesFromTMDB() : Flow<Resource<TopRatedTvFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val topRatedTvListFromTMDB = repository.getTopRatedSeriesFromTMDB()
            if (topRatedTvListFromTMDB.series.isNotEmpty()) {
                emit(Resource.Success(topRatedTvListFromTMDB))
            } else {
                emit(Resource.Error(message = "Now Playing Series Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGenreSeriesFromTMDB() : Flow<Resource<SeriesGenreFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val genreSeriesListFromTMDB = repository.genreSerieFromTMDB()
            if (genreSeriesListFromTMDB.genres.isNotEmpty()) {
                emit(Resource.Success(genreSeriesListFromTMDB))
            } else {
                emit(Resource.Error(message = "Series Genre Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
}