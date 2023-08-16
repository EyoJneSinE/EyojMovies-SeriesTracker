package com.eniskaner.eyojmovietrackerwithcompose.presentation.trend.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.eniskaner.eyojmovietrackerwithcompose.data.remote.moviedb.movies.MoviesResult
import com.eniskaner.eyojmovietrackerwithcompose.util.Constants.BACKDROP_URL
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPageImage(movie: List<MoviesResult>) {
    val pageCount = movie.size
    val pagerState = rememberPagerState()
    val currentTitle = pagerState.currentPage.takeIf { it in movie.indices }
        ?.let { movie[it].title ?: "" }
    val currentImage = pagerState.currentPage.takeIf { it in movie.indices }
        ?.let { movie[it].backdropPath }
    val currentImageUrl = BACKDROP_URL + currentImage
    Column(
        modifier = Modifier
        .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .background(MaterialTheme.colorScheme.inverseSurface, shape = RoundedCornerShape(16.dp))
            .padding(2.dp)
        ) {
            Text(
                text = currentTitle ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.titleLarge
            )
        }
        Box (
            modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(5.dp)
        ) {
            HorizontalPager(
                count = pageCount,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(60.dp))
                    .align(Alignment.Center),
                state = pagerState,
            ) { page ->
                val imagePainter = rememberAsyncImagePainter(model = currentImageUrl)
                Image(
                    painter = imagePainter,
                    contentDescription = currentTitle,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(40.dp))
                        .border(BorderStroke(4.dp, MaterialTheme.colorScheme.tertiary), RoundedCornerShape(40.dp))
                        .padding(5.dp),
                    contentScale = ContentScale.Crop
                )

            }
            Row(
                Modifier
                    .align(Alignment.BottomCenter)
                    .height(25.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(12.dp)

                    )
                }
            }
        }

    }

}