package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesDetails
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL


@Composable
fun SeriesDetailColumn(
    seriesDetail: SeriesDetails
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        val genreIds = seriesDetail.genres
        val genres = genreIds
        Column {
            Text(
                text = seriesDetail.name ?: "",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
            )
            Row {
                Column(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentHeight()) {
                    Image(painter = rememberAsyncImagePainter(model = POSTER_URL + seriesDetail.posterPath),
                        contentDescription = seriesDetail.name,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 40.dp,
                                    topEnd = 40.dp,
                                    bottomEnd = 4.dp,
                                    bottomStart = 4.dp
                                )
                            )
                            .border(
                                BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary),
                                RoundedCornerShape(
                                    topStart = 40.dp,
                                    topEnd = 40.dp,
                                    bottomEnd = 4.dp,
                                    bottomStart = 4.dp
                                )
                            )
                    )
                    if (seriesDetail.status == "Ended") {
                        Row {
                            Text(
                                text = "Status:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.status}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row {
                            Text(
                                text = "First air date:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(
                            text = "${seriesDetail.firstAirDate}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(2.dp),
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Row {
                            Text(
                                text = "Last air date:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(
                            text = "${seriesDetail.lastAirDate}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(2.dp),
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    } else {
                        Row {
                            Text(
                                text = "Status:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.status}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row {
                            Text(
                                text = "First air date:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(
                            text = "${seriesDetail.firstAirDate}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(2.dp),
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(5.dp))
                LazyColumn() {
                    item {
                        Row {
                            seriesDetail.tagline?.let {
                                if (it.isNotEmpty()) {
                                    Text(
                                        text = "Tagline:",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(2.dp),
                                        color = MaterialTheme.colorScheme.tertiary,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text(
                                        text = "${seriesDetail.tagline}",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(2.dp),
                                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            }
                        }
                    }
                    item {
                        Row {
                            Text(
                                text = "OverView:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(
                            text = "${seriesDetail.overview}",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(2.dp),
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    item {
                        Row {
                            Text(
                                text = "Genre:" ,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Column {
                                genres.forEach {
                                    val genreName = it.name
                                    Text(
                                        text = "${genreName}," ,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(2.dp),
                                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            }
                        }
                    }
                    item {
                        Row {
                            Text(
                                text = "Ratings:",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.voteAverage}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}