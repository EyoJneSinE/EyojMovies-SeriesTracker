package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies_cast.MovieCrew
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.RANDOM_POSTER

@Composable
fun MovieCrew(movieCrew: MovieCrew) {
    Column(
        modifier = Modifier
            .requiredHeightIn(30.dp, 500.dp)
            .padding(horizontal = 5.dp)
    ) {
        var profile = movieCrew.moviesCrewProfilePath
        if (profile == null) {
            profile = RANDOM_POSTER
        }
        Image(
            painter = rememberAsyncImagePainter(model = POSTER_URL + profile),
            contentDescription = movieCrew.moviesCrewName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(4.dp)
                .size(250.dp)
                .clip(CircleShape)
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary), CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        Row {
            Text(
                text = "Name: ",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
            )
            Text(
                text = "${movieCrew.moviesCrewName}",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Row {
            Text(
                text = "Job: ",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
            )
            Text(
                text = "${movieCrew.moviesCrewJob}",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}