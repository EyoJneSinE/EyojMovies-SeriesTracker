package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.MovieCastViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.MovieCrewViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.MovieDetailViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.MovieTrailerViewModel

@Composable
fun MovieDetailScreen(
    viewModel : MovieDetailViewModel = hiltViewModel(),
    castViewModel: MovieCastViewModel = hiltViewModel(),
    crewViewModel: MovieCrewViewModel = hiltViewModel(),
    trailerViewModel: MovieTrailerViewModel = hiltViewModel(),
    lifecycleOwner: LifecycleOwner
) {
    val state = viewModel.state.value
    val castState = castViewModel.state.value
    val crewState = crewViewModel.state.value
    val trailerState = trailerViewModel.state.value

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.945f)
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        item {
            Divider(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(2.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        item {
            Row(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                state.movie?.let {
                    BigPoster(movieDetail = it)
                }
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(2.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
                    .padding(4.dp)
            ) {
                state.movie?.let {
                    MovieDetailColumn(movieDetail = it)
                }
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(2.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        item {
            LazyRow(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 4.dp, vertical = 4.dp)
            ) {
                castState.cast?.let {
                    if (it.cast.isEmpty()) {
                        item {
                            Text(
                                text = "Movies Cast Can Not Found",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                color = MaterialTheme.colorScheme.onError,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                    itemsIndexed(it.cast) { index, moviesCast ->
                        MovieCast(movieCast = moviesCast)
                        if (index < it.cast.size - 1) {
                            Divider(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(2.dp)
                                    .height(300.dp),
                                color = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }
                }
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(2.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        item {
            LazyRow(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 4.dp, vertical = 4.dp)
            ) {
                if (crewState.crew.isEmpty()) {
                    item {
                        Text(
                            text = "Movies Crew Can Not Found",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onError,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                itemsIndexed(crewState.crew) {index, moviesCrew ->
                    MovieCrew(movieCrew = moviesCrew)
                    if (index < crewState.crew.size - 1) {
                        Divider(
                            modifier = Modifier
                                .padding(10.dp)
                                .width(2.dp)
                                .height(300.dp),
                            color = MaterialTheme.colorScheme.tertiary
                        )
                    }
                }
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(2.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        var moviesFoundTrailer = false
        item {
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .requiredHeightIn(min = 30.dp, max = 500.dp)) {
                items(trailerState.trailer) { moviesTrailer ->
                    val backGroundColor = MaterialTheme.colorScheme.tertiary

                    Row {
                        moviesTrailer.key?.let {
                            val isSuitableSeriesTrailer = moviesTrailer.name in listOf("Official Trailer", "Trailer", "Official") ||
                                    (moviesTrailer.type == "Trailer")
                            if (isSuitableSeriesTrailer && !moviesFoundTrailer) {
                                MoviesTrailerCard(
                                    lifecycleOwner = lifecycleOwner,
                                    trailerId = moviesTrailer.key,
                                    backgroundColor = backGroundColor
                                )
                                moviesFoundTrailer = true
                            }
                        }
                    }
                }
                item {
                    if (!moviesFoundTrailer) {
                        Text(
                            text = "Official Trailer Can Not Found",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onError,
                            style = MaterialTheme.typography.titleMedium
                        )
                    } else {
                        moviesFoundTrailer = false
                    }
                }
            }
        }
        item {
            Divider(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(2.dp),
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
