package com.eniskaner.eyojmovietrackerwithcompose.presentation.tv_detail.view

import android.view.View
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.eniskaner.eyojmovietrackerwithcompose.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun SeriesTrailer(
    lifecycleOwner: LifecycleOwner,
    trailerId : String
) {
    var isExpanded by remember { mutableStateOf(false) }
    val fullscreenListeners = mutableListOf<FullscreenListener>()
    Row(
        modifier = Modifier
            .padding(2.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessHigh
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.92f)
                .padding(2.dp)
        ) {
            Text(
                text = "Series Official Trailer: ",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold),
                color = MaterialTheme.colorScheme.tertiary,
            )
            if (isExpanded) {
                AndroidView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    factory = { context ->
                        val view = YouTubePlayerView(context)
                        val options : IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).fullscreen(1).build()
                        val playerListener: AbstractYouTubePlayerListener = object : AbstractYouTubePlayerListener() {
                            override fun onReady(youTubePlayer: YouTubePlayer) {
                                view.setCustomPlayerUi(DefaultPlayerUiController(view, youTubePlayer).rootView)
                                youTubePlayer.cueVideo(trailerId ?: "", 0f)
                            }
                        }
                        val webViewFullScreenListener : FullscreenListener = object : FullscreenListener {
                            override fun onEnterFullscreen(fullscreenView: View, exitFullscreen: () -> Unit) {
                                fullscreenListeners.forEach { it.onEnterFullscreen(fullscreenView, exitFullscreen) }
                            }

                            override fun onExitFullscreen() {
                                fullscreenListeners.forEach { it.onExitFullscreen() }
                            }

                        }
                        lifecycleOwner.lifecycle.addObserver(view)
                        view.enableAutomaticInitialization = false
                        view.addFullscreenListener(webViewFullScreenListener)
                        view.initialize(playerListener, options)
                        view
                    }
                )
            }
        }

        IconButton(onClick = { isExpanded = !isExpanded },
            modifier = Modifier
                .fillMaxWidth(0.08f)
                .padding(end = 10.dp)
        ) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (isExpanded) {
                    stringResource(id = R.string.show_less)
                } else {
                    stringResource(id = R.string.show_more)
                }
            )
        }
    }
}
