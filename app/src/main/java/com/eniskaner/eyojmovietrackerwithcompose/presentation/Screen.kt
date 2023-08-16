package com.eniskaner.eyojmovietrackerwithcompose.presentation

sealed class Screen (val route:String) {
    object MovieScreen : Screen("movie_screen")
    object MovieDetailScreen : Screen("movie_detail_screen")
    object SplashScreen : Screen("splash_screen")
    /*object FavoriteScreen : Screen("favorite_screen")*/
    object TrendingScreen : Screen("trending_screen")
    object TvScreen : Screen("tv_screen")
    object TvDetailScreen : Screen("tv_detail_screen")
}
