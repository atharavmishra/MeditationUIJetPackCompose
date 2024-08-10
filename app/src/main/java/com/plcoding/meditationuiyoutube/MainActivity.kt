package com.plcoding.meditationuiyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.plcoding.meditationuiyoutube.ui.HomeScreen
import com.plcoding.meditationuiyoutube.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                HomeScreen()
            }
        }
    }
}