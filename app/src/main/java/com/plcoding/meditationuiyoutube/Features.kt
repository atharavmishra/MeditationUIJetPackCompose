package com.plcoding.meditationuiyoutube

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Features(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val darkColor: Color,
    val mediumColor: Color
)
