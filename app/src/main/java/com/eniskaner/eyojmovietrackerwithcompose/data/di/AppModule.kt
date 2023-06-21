package com.eniskaner.eyojmovietrackerwithcompose.data.di

import com.eniskaner.eyojmovietrackerwithcompose.data.remote.MovieAPI
import com.eniskaner.eyojmovietrackerwithcompose.data.repo.MovieRepositoryImplementation
import com.eniskaner.eyojmovietrackerwithcompose.domain.repo.MovieRepository
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi() : MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI) : MovieRepository {
        return MovieRepositoryImplementation(api = api)
    }
}