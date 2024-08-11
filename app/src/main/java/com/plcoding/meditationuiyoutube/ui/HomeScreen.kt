package com.plcoding.meditationuiyoutube.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.ui.theme.ButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DarkerButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue
import com.plcoding.meditationuiyoutube.ui.theme.LightRed
import com.plcoding.meditationuiyoutube.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    val chips = listOf("Sweet sleep", "Insomnia", "Depression")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            Greeting()
            ChipSection(chips = chips)
            CurrentMeditation()
            FeaturedSection()
        }
    }


}

@Composable
@Preview(showBackground = true)
fun Greeting(
    name: String = "Atharv Mishra"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, end = 10.dp, start = 10.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning $name", style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )

        }
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "This is Search Bar",
            tint = Color.White,
            modifier = Modifier.size(25.dp)
        )

    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(
                    start = 10.dp, top = 15.dp, bottom = 15.dp
                )
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (selectedChipIndex == it) ButtonBlue
                    else DarkerButtonBlue
                )
                .padding(10.dp)) {
                Text(
                    text = chips[it],
                    color = TextWhite,
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(
                start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp
            )
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h1,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = "Meditation . 3-10 min",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = "Play Button",
            modifier = Modifier.size(16.dp),
            tint = Color.White
        )

    }
}

@Composable
fun FeaturedSection() {
    Column {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Good Morning")
        }
    }
}
