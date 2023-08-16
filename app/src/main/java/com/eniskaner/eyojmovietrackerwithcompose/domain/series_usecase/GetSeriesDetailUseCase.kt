package com.eniskaner.eyojmovietrackerwithcompose.domain.series_usecase

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_cast.CastingForSeriesFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesDetails
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_genre.SeriesGenreFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_video.GetSeriesTrailerFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import com.eniskaner.eyojmovietrackerwithcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun executeGetSeriesDetailsFromTMDB(seriesId: Int) : Flow<Resource<SeriesDetails>> = flow {
        try {
            emit(Resource.Loading())
            val getSeriesDetailsFromTMDB = repository.getSeriesDetailsFromTMDB(seriesId)
            if (getSeriesDetailsFromTMDB.seasons.isNotEmpty() || getSeriesDetailsFromTMDB.genres.isNotEmpty() || getSeriesDetailsFromTMDB.languages.isNotEmpty()) {
                emit(Resource.Success(getSeriesDetailsFromTMDB))
            } else {
                emit(Resource.Error(message = "Series Details Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGetSeriesVideosFromTMDB(seriesId: Int) : Flow<Resource<GetSeriesTrailerFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val getSeriesTrailerFromTMDB = repository.getTvVideosFromTMDB(seriesId)
            if (getSeriesTrailerFromTMDB.results.isNotEmpty()) {
                emit(Resource.Success(getSeriesTrailerFromTMDB))
            } else {
                emit(Resource.Error(message = "Trailers Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }

    fun executeGetSeriesCastFromTMDB(seriesId: Int) : Flow<Resource<CastingForSeriesFromTMDB>> = flow {
        try {
            emit(Resource.Loading())
            val getSeriesCastFromTMDB = repository.getSeriesCastFromTMDB(seriesId)
            if (getSeriesCastFromTMDB.cast.isNotEmpty() || getSeriesCastFromTMDB.crew.isNotEmpty()) {
                emit(Resource.Success(getSeriesCastFromTMDB))
            } else {
                emit(Resource.Error(message = "Cast And Crew Can't Found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Internet connection error!!!"))
        }
    }
    fun executeGenreSerieFromTMDB() : Flow<Resource<SeriesGenreFromTMDB>> = flow {
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