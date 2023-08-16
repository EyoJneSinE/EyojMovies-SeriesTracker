package com.eniskaner.eyojmovietrackerwithcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eniskaner.eyojmovietrackerwithcompose.presentation.Screen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.view.MovieDetailScreen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.view.MovieScreen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.splash.SplashScreen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.trend.view.TrendingScreen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv.view.SeriesScreen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view.TvDetailScreen
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.MOVIE_ID
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.SERIES_ID

@Composable
fun Navigation(navController: NavHostController,
               lifecycleOwner: LifecycleOwner) {
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        /*composable(route = Screen.FavoriteScreen.route) {
            FavoriteScreen()
        }*/
        composable(route = Screen.TrendingScreen.route) {
            TrendingScreen(navController)
        }
        composable(route = Screen.MovieScreen.route) {
            MovieScreen(navController)
        }
        composable(route = Screen.MovieDetailScreen.route + "/{${MOVIE_ID}}") {
            MovieDetailScreen(lifecycleOwner = lifecycleOwner)
        }
        composable(route = Screen.TvScreen.route) {
            SeriesScreen(navController)
        }
        composable(route = Screen.TvDetailScreen.route + "/{${SERIES_ID}}") {
            TvDetailScreen(lifecycleOwner = lifecycleOwner)
        }
    }
}