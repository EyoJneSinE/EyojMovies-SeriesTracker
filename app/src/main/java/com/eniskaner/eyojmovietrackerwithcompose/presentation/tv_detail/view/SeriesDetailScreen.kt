package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

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
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.SeiresTrailerViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.SeriesCastViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.SeriesCrewViewModel
import com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.SeriesDetailViewModel

@Composable
fun TvDetailScreen(
    viewModel : SeriesDetailViewModel = hiltViewModel(),
    castViewModel: SeriesCastViewModel = hiltViewModel(),
    crewViewModel: SeriesCrewViewModel = hiltViewModel(),
    trailerViewModel: SeiresTrailerViewModel = hiltViewModel(),
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
                state.series?.let {
                    SeriesPoster(seriesDetail = it)
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
                    .requiredHeightIn(min = 300.dp, max = 470.dp)
                    .padding(4.dp)
            ) {
                state.series?.let {
                    SeriesDetailColumn(seriesDetail = it)
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .requiredHeightIn(min = 20.dp, max = 700.dp)
                    .padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
                item {
                    state.series?.lastEpisodeToAir?.let {lastEpisode ->
                        val backGroundColor = MaterialTheme.colorScheme.onSecondary
                        LastEpisodeCard(seriesDetail = state.series, backgroundColor = backGroundColor)
                    }
                    state.series?.let {
                        if (it.lastEpisodeToAir == null) {
                            Text(
                                text = "Series Last Episode To Air Contents Can Not Found",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp, horizontal = 8.dp),
                                textAlign = TextAlign.Start,
                                color = MaterialTheme.colorScheme.onError,
                                style = MaterialTheme.typography.titleMedium
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .requiredHeightIn(min = 20.dp, max = 700.dp)
                    .padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
                item {
                    state.series?.nextEpisodeToAir?.let {nextEpisode ->
                        val backGroundColor = MaterialTheme.colorScheme.inverseSurface
                        NextEpisodeCard(seriesDetail = state.series, backgroundColor = backGroundColor)
                    }
                    state.series?.let {
                        if (it.nextEpisodeToAir == null) {
                            Text(
                                text = "Series Next Episode To Air Contents Can Not Found",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp, horizontal = 8.dp),
                                textAlign = TextAlign.Start,
                                color = MaterialTheme.colorScheme.onError,
                                style = MaterialTheme.typography.titleMedium
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
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 4.dp)
                    .requiredHeightIn(min = 20.dp, max = 6000.dp)
            ) {
                state.series?.let {
                    itemsIndexed(it.seasons) {index, seriesSeasons ->
                        val backGroundColor = if (index % 2 == 0) {
                            MaterialTheme.colorScheme.onSecondary
                        } else {
                            MaterialTheme.colorScheme.inverseSurface
                        }
                        SeasonsCard(seriesSeason = seriesSeasons, backGroundColor)
                    }
                }
            }
            state.series?.seasons?.let {
                if (it.isEmpty()) {
                    Text(
                        text = "Series Seasons Can Not Found",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.onError,
                        style = MaterialTheme.typography.titleMedium
                    )
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeightIn(min = 20.dp, max = 400.dp)
                    .padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
                state.series?.let {createdBy ->
                    itemsIndexed(createdBy.productionCompanies) {index, seriesProductionCompany ->
                        val backGroundColor = if (index % 2 == 0) {
                            MaterialTheme.colorScheme.onSecondary
                        } else {
                            MaterialTheme.colorScheme.inverseSurface
                        }
                        ProductionsCard(seriesProductionCompany = seriesProductionCompany, backgroundColor = backGroundColor)
                    }
                }
            }
            state.series?.productionCompanies?.let {
                if (it.isEmpty()) {
                    Text(
                        text = "Series Production Companies Can Not Found",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.onError,
                        style = MaterialTheme.typography.titleMedium
                    )
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
                                text = "Series Cast Can Not Found",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                color = MaterialTheme.colorScheme.onError,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                    itemsIndexed(it.cast) { index, seriesCast ->
                        SeriesCast(seriesCast = seriesCast)
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
                .padding(vertical = 4.dp, horizontal = 4.dp)
            ) {
                if (crewState.crew.isEmpty()) {
                    item {
                        Text(
                            text = "Series Crew Can Not Found",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onError,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                itemsIndexed(crewState.crew) { index, seriesCrew ->
                    SeriesCrew(seriesCrew = seriesCrew)
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
        var seriesfoundTrailer = false
        item {
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .requiredHeightIn(min = 30.dp, max = 500.dp)) {
                items(trailerState.trailer) { seriesTrailer ->
                    val backGroundColor = MaterialTheme.colorScheme.inverseSurface

                    Row {
                        seriesTrailer.key?.let {
                            val isSuitableSeriesTrailer = seriesTrailer.name in listOf("Official Trailer", "Trailer", "Official") ||
                                    (seriesTrailer.type == "Trailer")
                            if (isSuitableSeriesTrailer && !seriesfoundTrailer) {
                                SeriesTrailerCard(
                                    lifecycleOwner = lifecycleOwner,
                                    trailerId = seriesTrailer.key,
                                    backgroundColor = backGroundColor
                                )
                                seriesfoundTrailer = true
                            }
                        }
                    }
                }
                item {
                    if (!seriesfoundTrailer) {
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
                        seriesfoundTrailer = false
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
