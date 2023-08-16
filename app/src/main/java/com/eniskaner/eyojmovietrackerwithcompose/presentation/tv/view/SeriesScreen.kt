package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eniskaner.eyojmovietrackerwithcompose.presentation.Screen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv.SeriesEvent
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv.SeriesGenreViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv.SeriesViewModel

@Composable
fun SeriesScreen(
    navController: NavController,
    viewModel : SeriesViewModel = hiltViewModel(),
    genreViewModel: SeriesGenreViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val stateGenre = genreViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
        Column {
            SeriesSearchBar(
                modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                hint = "the",
                onSearch = {
                    viewModel.onEvent(SeriesEvent.SearchSeries(it))
                }
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                state.series?.let { series->
                    series.series.forEach {
                        item {
                            TopRatedSeriesList(series = it, seriesGenre = stateGenre.seriesGenre, onItemClick = {
                                navController.navigate(Screen.TvDetailScreen.route + "/${it.id}")
                            })
                        }
                    }
                }
            }
        }
    }
}
