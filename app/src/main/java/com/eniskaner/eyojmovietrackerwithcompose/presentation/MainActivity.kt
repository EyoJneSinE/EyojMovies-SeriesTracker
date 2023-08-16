package com.eniskaner.eyojmovietrackerwithcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.rememberNavController
import com.eniskaner.eyojmovietrackerwithcompose.R
import com.eniskaner.eyojmovietrackerwithcompose.presentation.navigation.BottomNavItem
import com.eniskaner.eyojmovietrackerwithcompose.presentation.navigation.BottomNavigationBar
import com.eniskaner.eyojmovietrackerwithcompose.presentation.navigation.Navigation
import com.eniskaner.eyojmovietrackerwithcompose.presentation.ui.theme.EyojMovieTrackerWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EyojMovieTrackerWithComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold (
                    bottomBar = {
                        BottomNavigationBar(items = listOf(
                            BottomNavItem(
                                name = "Trending",
                                route = "trending_screen",
                                icon = ImageVector.vectorResource(R.drawable.ic_action_trend_stars)
                            ),
                            /*BottomNavItem(
                                name = "Favorite",
                                route = "favorite_screen",
                                icon = Icons.Rounded.FavoriteBorder
                            ),*/
                            BottomNavItem(
                                name = "Series",
                                route = "tv_screen",
                                icon = ImageVector.vectorResource(R.drawable.ic_action_series)
                            ),
                            BottomNavItem(
                                name = "Movies",
                                route = "movie_screen",
                                icon = ImageVector.vectorResource(R.drawable.ic_action_movies)
                            )
                        ), navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController, this)
                }
            }
        }
    }
}