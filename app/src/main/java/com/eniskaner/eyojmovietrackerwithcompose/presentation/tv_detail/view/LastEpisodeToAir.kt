package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.R
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesDetails
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.RANDOM_POSTER

@Composable
fun LastEpisodeToAir(
    seriesDetail: SeriesDetails
) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(2.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessHigh
                )
            )
    ) {
        var profile = seriesDetail.lastEpisodeToAir.stillPath
        if (profile == null) {
            profile = RANDOM_POSTER
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.92f)
                .padding(2.dp)
        ) {
            Row(modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = "Last Episode: ",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold),
                    color = MaterialTheme.colorScheme.tertiary,
                )
                Text(
                    text = "${seriesDetail.lastEpisodeToAir.name}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.ExtraBold),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                )
            }
            Row(modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = "Air Date: ",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold),
                    color = MaterialTheme.colorScheme.tertiary,
                )
                Text(
                    text = "${seriesDetail.lastEpisodeToAir.airDate}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.ExtraBold),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                )
            }
            Row {
                if (isExpanded) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = POSTER_URL + profile),
                            contentDescription = seriesDetail.lastEpisodeToAir.name,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .padding(2.dp)
                                .fillMaxWidth()
                                .height(250.dp)
                                .clip(RoundedCornerShape(40.dp))
                                .border(
                                    BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary),
                                    RoundedCornerShape(40.dp)
                                )
                        )
                        Text(
                            text = seriesDetail.lastEpisodeToAir.name ?: "",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(4.dp),
                            color = MaterialTheme.colorScheme.tertiary,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Row {
                            Text(
                                text = "OverView: ",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.lastEpisodeToAir.overview}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row {
                            Text(
                                text = "Season: ",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.lastEpisodeToAir.seasonNumber}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row {
                            Text(
                                text = "Episode: ",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.lastEpisodeToAir.episodeNumber}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row {
                            Text(
                                text = "Run Time: ",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.lastEpisodeToAir.runtime ?: ""} dk",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Row {
                            Text(
                                text = "Ratings: ",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesDetail.lastEpisodeToAir.voteAverage}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        seriesDetail.lastEpisodeToAir.airDate?.let { airDate ->
                            if (airDate.isNotEmpty()) {
                                Row {
                                    Text(
                                        text = "Air Date: ",
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(4.dp),
                                        color = MaterialTheme.colorScheme.tertiary,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text(
                                        text = airDate,
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
        IconButton(onClick = { isExpanded = !isExpanded },
            modifier = Modifier
                .fillMaxWidth(0.08f)
                .padding(end = 10.dp)
        ) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (isExpanded) {
                    stringResource(id = R.string.show_less)
                } else {
                    stringResource(id = R.string.show_more)
                }
            )
        }
    }
}
