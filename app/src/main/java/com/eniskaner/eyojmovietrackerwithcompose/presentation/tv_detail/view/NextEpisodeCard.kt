package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.seriesdb.series_details.SeriesDetails

@Composable
fun NextEpisodeCard(seriesDetail: SeriesDetails, backgroundColor: Color) {
    Card(
        backgroundColor = backgroundColor,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        NextEpisodeToAir(seriesDetail = seriesDetail)
    }
}