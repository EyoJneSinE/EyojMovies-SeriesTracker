package com.eniskaner.eyojmovietrackerwithcompose.presentation.movies.view

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
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies.MoviesResult
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_genre.MoviesGenre
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL

@Composable
fun MoviesList(
    movie : MoviesResult,
    moviesGenre: List<MoviesGenre>,
    onItemClick : (MoviesResult) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        val matchedGenres = moviesGenre.filter { moviesGenre ->
            movie.genreIds.any { it == moviesGenre.id }
        }
        Image(
            painter = rememberAsyncImagePainter(model = POSTER_URL + movie.posterPath),
            contentDescription = movie.title,
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
                    BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary),
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
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                movie.title ?: "",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            Row {
                Text(
                    "Genre: ",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.primary,
                )
                Column {
                    matchedGenres.forEach { matchedGenre ->
                        Text(
                            "${matchedGenre.name},",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row {
                Text(
                    "Release Date: ",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    "${movie.releaseDate}",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}