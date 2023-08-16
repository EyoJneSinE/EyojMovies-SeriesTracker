package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.view

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movie_details.GetMovieDetailsFromId
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL

@Composable
fun MovieDetailColumn(
    movieDetail: GetMovieDetailsFromId
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .padding(10.dp),
    ) {
        val genreIds = movieDetail.genres
        val genres = genreIds

        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .wrapContentHeight()
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = POSTER_URL + movieDetail.posterPath),
                contentDescription = movieDetail.title,
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
                    .border(BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary),
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
                    text = "Release Date:",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(2.dp),
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
            }
            Text(
                text = "${movieDetail.releaseDate}",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(
            modifier = Modifier.padding(5.dp)
        )
        LazyColumn() {
            item {
                Text(
                    text = movieDetail.title ?: "",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
                )
                Row {
                    Text(
                        text = "Tagline:",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(2.dp),
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                    )
                    Text(
                        text = "${movieDetail.tagline}",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(2.dp),
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
            item {
                Row {
                    Text(
                        text = "Genre:" ,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(4.dp),
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                    )
                    Column {
                        genres.forEach {
                            val genreName = it.name
                            Text(
                                text = "${genreName ?: ""},",
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(4.dp),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
            item {
                Text(
                    text = "OverView:",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
                Text(
                    text = "${movieDetail.overview}",
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    style = MaterialTheme.typography.titleMedium
                )
                Row {
                    Text(
                        text = "Ratings:",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(4.dp),
                        color = MaterialTheme.colorScheme.tertiary,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                    )
                    Text(
                        text = "${movieDetail.voteAverage}",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(4.dp),
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}