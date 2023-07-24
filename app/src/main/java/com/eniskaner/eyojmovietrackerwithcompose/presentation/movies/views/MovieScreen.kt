package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eniskaner.eyojmovietrackerwithcompose.presentation.Screen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesEvent
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel : MoviesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {

        Column() {

            MovieSearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                hint = "marvel",
                onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                }
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) {movie ->
                    MovieListRow(movie = movie, onItemClick = {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${movie.imdbID}")
                    } )
                }
            }
        }
    }
}