package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.domain.model.MovieDetail

@Composable
fun MovieDetailRow(movieDetail: MovieDetail) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = rememberImagePainter(data = movieDetail.Poster),
            contentDescription = movieDetail.Title,
            modifier = Modifier
                .padding(16.dp)
                .size(300.dp, 300.dp)
                .clip(RectangleShape)
                .align(CenterHorizontally)
        )
        Text(text = movieDetail.Title,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(14.dp),
            color = Color.White
        )
        Text(text = movieDetail.Year,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(14.dp),
            color = Color.White
        )
        Text(text = movieDetail.Actors,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(14.dp),
            color = Color.White
        )
        Text(text = movieDetail.Country,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(14.dp),
            color = Color.White
        )
        Text(text = "Director: ${movieDetail.Director}",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(14.dp),
            color = Color.White
        )
        Text(text = "IMDB Rating: ${movieDetail.imdbRating}",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(14.dp),
            color = Color.White
        )
    }
}