package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eniskaner.eyojmovietrackerwithcompose.presentation.Screen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesEvent
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesGenreViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel : MoviesViewModel = hiltViewModel(),
    genreViewModel : MoviesGenreViewModel = hiltViewModel()
) {
    val state = viewModel.stateFromTMDB.value
    val stateMoviesGenre = genreViewModel.state.value

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.inverseSurface)
    ) {

        Column() {

            MovieSearchBar(
                modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                hint = "marvel",
                onSearch = {
                    viewModel.onEvent(MoviesEvent.SearchMovies(it))
                }
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.movies) {movie ->
                    MoviesList(movie = movie, moviesGenre = stateMoviesGenre.moviesGenre, onItemClick = {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                    } )
                }
            }
        }
    }
}