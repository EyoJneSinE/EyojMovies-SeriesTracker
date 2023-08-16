package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

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
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_cast.Crew
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.POSTER_URL

@Composable
fun SeriesCrew(seriesCrew: Crew) {
    Column(modifier = Modifier
        .requiredHeightIn(30.dp, 500.dp)
        .padding(horizontal = 5.dp)
    ) {
        var profile = seriesCrew.seriesCrewProfilePath
        if (profile == null) {
            profile = Constants.RANDOM_POSTER
        }
        Image(
            painter = rememberAsyncImagePainter(model = POSTER_URL + profile),
            contentDescription = seriesCrew.seriesCrewName,
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
                text = "${seriesCrew.seriesCrewName}",
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
                text = "${seriesCrew.seriesCrewJob}",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}