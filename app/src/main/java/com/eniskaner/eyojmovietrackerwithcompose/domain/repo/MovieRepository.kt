package com.eniskaner.eyojmovietrackerwithcompose.domain.repo

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

interface MovieRepository {

    suspend fun getMoviesFromTMDB(): GetMovieFromId

    suspend fun getMovieDetailsFromTMDB(movieId: Int): GetMovieDetailsFromId

    suspend fun searchMovieFromTMDB(search: String): GetMovieFromId

    suspend fun genreMovieFromTMDB(): GenresFromTMDB

    suspend fun getVideosFromTMDB(movieId:Int): GetTrailerFromMovieId

    suspend fun getNowPlayingMoviesFromTMDB(): GetMovieFromId

    suspend fun getCastFromTMDB(movieId:Int): CastingForMovieFromTMDB

    suspend fun getSeriesFromTMDB(): TopRatedTvFromTMDB

    suspend fun getSeriesDetailsFromTMDB(seriesId: Int): SeriesDetails

    suspend fun searchSerieFromTMDB(search: String): TopRatedTvFromTMDB

    suspend fun genreSerieFromTMDB(): SeriesGenreFromTMDB

    suspend fun getTvVideosFromTMDB(seriesId:Int): GetSeriesTrailerFromTMDB

    suspend fun getTopRatedSeriesFromTMDB(): TopRatedTvFromTMDB

    suspend fun getSeriesCastFromTMDB(seriesId:Int): CastingForSeriesFromTMDB
}