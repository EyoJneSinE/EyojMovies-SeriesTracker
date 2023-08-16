package com.eniskaner.eyojmovietrackerwithcompose.presentation.trend.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.top_rated_series.SeriesResult
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants

@Composable
fun TrendingSeriesList(
    series : SeriesResult,
    onItemClick : (SeriesResult) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(series) }
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.White)
                .clip(RoundedCornerShape(5.dp))
        )
        Image(
            painter = rememberAsyncImagePainter(model = Constants.POSTER_URL + series.posterPath),
            contentDescription = series.name,
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .height(270.dp)
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
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                series.name ?: "",
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center
            )
            Text(
                series.firstAirDate ?: "",
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center
            )
        }
    }
}