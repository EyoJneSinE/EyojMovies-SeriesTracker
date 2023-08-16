package com.eniskaner.eyojmovietrackerwithcompose.data.remote

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
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.MOVIEDB_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {


    @GET("/3/trending/movie/day")
    suspend fun getMoviesFromTMDB(
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): GetMovieFromId

    @GET("/3/movie/{movieId}")
    suspend fun getMovieDetailFromTMDB(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): GetMovieDetailsFromId

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMoviesFromTMDB(
        @Query("api_key") apiKey: String= MOVIEDB_KEY
    ): GetMovieFromId

    @GET("/3/search/movie")
    suspend fun searchMovieFromTMDB(
        @Query("query") query:String?,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): GetMovieFromId

    @GET("/3/genre/movie/list")
    suspend fun genreMovieFromTMDB(
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): GenresFromTMDB

    @GET("/3/movie/{movieId}/videos")
    suspend fun getVideosFromTMDB(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): GetTrailerFromMovieId

    @GET("/3/movie/{movieId}/credits")
    suspend fun getCastFromTMDB(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): CastingForMovieFromTMDB

    @GET("/3/trending/tv/day")
    suspend fun getSeriesFromTMDB(
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): TopRatedTvFromTMDB

    @GET("/3/tv/{seriesId}")
    suspend fun getSeriesDetailsFromTMDB(
        @Path("seriesId") seriesId: Int,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): SeriesDetails

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTv(
        @Query("api_key") apikey: String= MOVIEDB_KEY
    ): TopRatedTvFromTMDB

    @GET("/3/search/tv")
    suspend fun searchSeriesFromTMDB(
        @Query("query") query: String?,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): TopRatedTvFromTMDB

    @GET("/3/genre/tv/list")
    suspend fun genreSerieFromTMDB(
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): SeriesGenreFromTMDB

    @GET("/3/tv/{seriesId}/videos")
    suspend fun getTvVideosFromTMDB(
        @Path("seriesId") seriesId: Int,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): GetSeriesTrailerFromTMDB

    @GET("/3/tv/{seriesId}/credits")
    suspend fun getTvCastFromTMDB(
        @Path("seriesId") seriesId: Int,
        @Query("api_key") apiKey: String=MOVIEDB_KEY
    ): CastingForSeriesFromTMDB




}