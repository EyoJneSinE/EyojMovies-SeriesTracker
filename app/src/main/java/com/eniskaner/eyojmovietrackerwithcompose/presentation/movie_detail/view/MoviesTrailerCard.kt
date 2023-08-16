package com.eniskaner.eyojmovietrackerwithcompose.presentation.movie_detail.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner

@Composable
fun MoviesTrailerCard(lifecycleOwner: LifecycleOwner,
                      trailerId : String, backgroundColor: Color
) {
    Card(
        backgroundColor = backgroundColor,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        MovieTrailer(lifecycleOwner = lifecycleOwner, trailerId = trailerId)
    }
}