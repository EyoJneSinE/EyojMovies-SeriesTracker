package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesSeason
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.RANDOM_POSTER

@Composable
fun SeriesSeasons(seriesSeason: SeriesSeason) {
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
        var profile = seriesSeason.posterPath
        if (profile == null) {
            profile = RANDOM_POSTER
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.92f)
                .padding(2.dp)
        ) {
            Row {
                Text(
                    text = "Season: ",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
                Text(
                    text =  seriesSeason.seasonNumber.toString(),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.ExtraBold)
                )
            }
            Row {
                Text(
                    text = "Name: ",
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
                Text(
                    text = "${ seriesSeason.name}",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.ExtraBold)
                )
            }
            Row {
                if (isExpanded) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = Constants.POSTER_URL + profile),
                            contentDescription = seriesSeason.name,
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
                        Row {
                            Text(
                                text = "Air Date: ",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesSeason.airDate}",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(2.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .requiredHeightIn(min = 20.dp, max = 400.dp)
                    ) {
                        item {
                            Text(
                                text = "OverView: ",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.tertiary,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "${seriesSeason.overview}",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Row {
                                Text(
                                    text = "Episode count: ",
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.padding(4.dp),
                                    color = MaterialTheme.colorScheme.tertiary,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Text(
                                    text = "${seriesSeason.episodeCount}",
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.padding(4.dp),
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
                                    text = "${seriesSeason.voteAverage}",
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.padding(4.dp),
                                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                                    style = MaterialTheme.typography.bodyLarge
                                )
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