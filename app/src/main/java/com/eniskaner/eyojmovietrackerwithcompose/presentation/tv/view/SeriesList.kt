package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_genre.SeriesGenre
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.top_rated_series.SeriesResult
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL

@Composable
fun TopRatedSeriesList(
    series : SeriesResult,
    seriesGenre: List<SeriesGenre>,
    onItemClick : (SeriesResult) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(series) }
            .padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        val matchedGenres = seriesGenre.filter { seriesGenre ->
            series.genreIds.any { it == seriesGenre.id }
        }

        Image(
            painter = rememberAsyncImagePainter(model = POSTER_URL + series.posterPath),
            contentDescription = series.name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(10.dp)
                .size(150.dp, 250.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp,
                        bottomEnd = 4.dp,
                        bottomStart = 4.dp
                    )
                )
                .border(
                    BorderStroke(4.dp, MaterialTheme.colorScheme.onError),
                    RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp,
                        bottomEnd = 4.dp,
                        bottomStart = 4.dp
                    )
                )
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ) {
            Text(
                series.name ?: "",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.errorContainer,
            )
            Spacer(
                modifier = Modifier
                    .padding(vertical = 5.dp)
            )
            Row {
                Text(
                    "Genre: ",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.errorContainer,
                )
                Column {
                    matchedGenres.forEach { matchedGenre ->
                        Text(
                            "${matchedGenre.name},",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onErrorContainer,
                        )
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = 5.dp)
            )
            Row {
                Text(
                    "First air date: ",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.errorContainer,
                )
                Text(
                    "${series.firstAirDate}",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onErrorContainer,
                )
            }
        }
    }
}