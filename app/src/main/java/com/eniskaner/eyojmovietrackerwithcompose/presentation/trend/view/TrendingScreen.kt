package com.eniskaner.eyojmovietrackerwithcompose.presentation.trend.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eniskaner.eyojmovietrackerwithcompose.presentation.Screen
import com.eniskaner.eyojmovietrackerwithcompose.presentation.trend.TrendingViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TrendingScreen(
    navController: NavController,
    viewModel : TrendingViewModel = hiltViewModel()
) {

    val stateMovies = viewModel.movieState.value
    val stateSeries = viewModel.serieState.value

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.945f)
            .background(MaterialTheme.colorScheme.inverseSurface)
    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            ) {
            LazyColumn (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    if (stateMovies.movies.isNotEmpty()) {
                        HorizontalPageImage(movie = stateMovies.movies)
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f)
                    ) {
                    Spacer(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(Color.White)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Text(
                        text = "Now Playing Movies",
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.tertiary,
                        textAlign = TextAlign.End,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    LazyColumn() {
                        items(stateMovies.movies) { movie->
                            TrendingMovieList(movie = movie, onItemClick = {
                                navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")
                            })
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                    ) {
                    Spacer(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(Color.White)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Text(
                        text = "Top Rated Series",
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.tertiary,
                        textAlign = TextAlign.End,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    LazyColumn() {
                        items(stateSeries.series) { serie ->
                            TrendingSeriesList(series = serie, onItemClick = {
                                navController.navigate(Screen.TvDetailScreen.route + "/${serie.id}")
                            })
                        }
                    }
                }
            }
        }
    }
}
