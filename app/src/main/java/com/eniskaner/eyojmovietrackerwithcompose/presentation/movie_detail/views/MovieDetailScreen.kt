package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    viewModel : MovieDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movie) { movieDetail ->
                    MovieDetailRow(movieDetail = movieDetail)
                }
            }
        }
    }
}
