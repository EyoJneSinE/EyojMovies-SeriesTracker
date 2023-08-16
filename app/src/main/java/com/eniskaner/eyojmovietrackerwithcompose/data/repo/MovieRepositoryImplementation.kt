package com.eniskaner.eyojmovietrackerwithcompose.data.repo

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.MovieAPI
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movie_details.GetMovieDetailsFromId
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies.GetMovieFromId
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_cast.CastingForMovieFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_genre.GenresFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_video.GetTrailerFromMovieId
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_cast.CastingForSeriesFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesDetails
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_genre.SeriesGenreFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_video.GetSeriesTrailerFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.top_rated_series.TopRatedTvFromTMDB
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplementation @Inject constructor(private val api: MovieAPI) : MovieRepository {

    override suspend fun getMoviesFromTMDB(): GetMovieFromId {
        return api.getMoviesFromTMDB()
    }

    override suspend fun getMovieDetailsFromTMDB(movieId: Int): GetMovieDetailsFromId {
        return api.getMovieDetailFromTMDB(movieId = movieId)
    }

    override suspend fun searchMovieFromTMDB(search: String): GetMovieFromId {
        return api.searchMovieFromTMDB(search)
    }

    override suspend fun genreMovieFromTMDB(): GenresFromTMDB {
        return api.genreMovieFromTMDB()
    }

    override suspend fun getVideosFromTMDB(movieId: Int): GetTrailerFromMovieId {
        return api.getVideosFromTMDB(movieId)
    }

    override suspend fun getNowPlayingMoviesFromTMDB(): GetMovieFromId {
        return api.getNowPlayingMoviesFromTMDB()
    }

    override suspend fun getCastFromTMDB(movieId: Int): CastingForMovieFromTMDB {
        return api.getCastFromTMDB(movieId)
    }

    override suspend fun getSeriesFromTMDB(): TopRatedTvFromTMDB {
        return  api.getSeriesFromTMDB()
    }

    override suspend fun getSeriesDetailsFromTMDB(seriesId: Int): SeriesDetails {
        return api.getSeriesDetailsFromTMDB(seriesId)
    }

    override suspend fun searchSerieFromTMDB(search: String): TopRatedTvFromTMDB {
        return api.searchSeriesFromTMDB(search)
    }

    override suspend fun genreSerieFromTMDB(): SeriesGenreFromTMDB {
        return api.genreSerieFromTMDB()
    }

    override suspend fun getTvVideosFromTMDB(seriesId: Int): GetSeriesTrailerFromTMDB {
        return api.getTvVideosFromTMDB(seriesId)
    }

    override suspend fun getTopRatedSeriesFromTMDB(): TopRatedTvFromTMDB {
        return api.getTopRatedTv()
    }

    override suspend fun getSeriesCastFromTMDB(seriesId: Int): CastingForSeriesFromTMDB {
        return api.getTvCastFromTMDB(seriesId)
    }
}