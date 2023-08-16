package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

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
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesDetails
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.BACKDROP_URL

@Composable
fun SeriesPoster(seriesDetail: SeriesDetails) {
    Column(
        modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .padding(2.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = BACKDROP_URL + seriesDetail.backdropPath),
            contentDescription = seriesDetail.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .clip(RoundedCornerShape(40.dp))
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary), RoundedCornerShape(40.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
    }
}