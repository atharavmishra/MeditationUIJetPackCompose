package com.plcoding.meditationuiyoutube.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.BottomMenuContent
import com.plcoding.meditationuiyoutube.Features
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.standardQuadFromTo
import com.plcoding.meditationuiyoutube.ui.theme.AquaBlue
import com.plcoding.meditationuiyoutube.ui.theme.Beige1
import com.plcoding.meditationuiyoutube.ui.theme.Beige2
import com.plcoding.meditationuiyoutube.ui.theme.Beige3
import com.plcoding.meditationuiyoutube.ui.theme.BlueViolet1
import com.plcoding.meditationuiyoutube.ui.theme.BlueViolet2
import com.plcoding.meditationuiyoutube.ui.theme.BlueViolet3
import com.plcoding.meditationuiyoutube.ui.theme.ButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DarkerButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue
import com.plcoding.meditationuiyoutube.ui.theme.LightGreen1
import com.plcoding.meditationuiyoutube.ui.theme.LightGreen2
import com.plcoding.meditationuiyoutube.ui.theme.LightGreen3
import com.plcoding.meditationuiyoutube.ui.theme.LightRed
import com.plcoding.meditationuiyoutube.ui.theme.OrangeYellow1
import com.plcoding.meditationuiyoutube.ui.theme.OrangeYellow2
import com.plcoding.meditationuiyoutube.ui.theme.OrangeYellow3
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
            FeaturedSection(
                listFeatures = listOf(
                    Features(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ), Features(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ), Features(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ), Features(
                        title = "Calming sounds", R.drawable.ic_headphone, Beige1, Beige2, Beige3
                    )
                )
            )
            MenuItem(
                list = listOf(
                    BottomMenuContent("Home", R.drawable.ic_home),
                    BottomMenuContent("Meditate", R.drawable.ic_bubble),
                    BottomMenuContent("Sleep", R.drawable.ic_moon),
                    BottomMenuContent("Music", R.drawable.ic_music),
                    BottomMenuContent("Profile", R.drawable.ic_profile)
                )
            )

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedSection(
    listFeatures: List<Features>
) {
    Column(modifier = Modifier.fillMaxHeight(0.8f)) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp, bottom = 100.dp
            ), modifier = Modifier.fillMaxHeight()
        ) {
            items(listFeatures.size) {
                FeatureItem(feature = listFeatures[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Features
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath, color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath, color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp))

        }
    }
}

@Composable
fun MenuItem(
    list: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemState: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemState)
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        list.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighLightColor = activeHighLightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }

}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean,
    activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.text,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )

        }
        Text(
            text = item.text, color = if (isSelected) activeTextColor else inactiveTextColor
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
