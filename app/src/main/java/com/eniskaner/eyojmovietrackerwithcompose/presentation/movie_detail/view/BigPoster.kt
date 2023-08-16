package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movie_details.GetMovieDetailsFromId
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.BACKDROP_URL

@Composable
fun BigPoster(movieDetail: GetMovieDetailsFromId) {
    Column(
        modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .padding(2.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = BACKDROP_URL + movieDetail.backdropPath),
            contentDescription = movieDetail.title,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary), RoundedCornerShape(40.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
    }
}
