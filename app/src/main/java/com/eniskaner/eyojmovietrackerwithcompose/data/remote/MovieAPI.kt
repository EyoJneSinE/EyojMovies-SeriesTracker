package com.eniskaner.eyojmovietrackerwithcompose.data.remote

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.MovieDetailDTO
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.dto.MoviesDTO
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://www.omdbapi.com/?apikey=yourapikey&s=deadpool
    //https://www.omdbapi.com/?apikey=yourapikey&i=tt1431045

    @GET(".")
    suspend fun getMovies(
        @Query("s") search: String,
        @Query("apikey") apikey : String = API_KEY
    ) : MoviesDTO

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apikey : String = API_KEY
    ) : MovieDetailDTO

}