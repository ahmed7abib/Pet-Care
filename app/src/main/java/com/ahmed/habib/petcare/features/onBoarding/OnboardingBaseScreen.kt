package com.ahmed.habib.petcare.features.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.features.dashboard.DashboardScreen
import com.ahmed.habib.petcare.ui.theme.Blue1
import com.ahmed.habib.petcare.ui.theme.Grey5
import com.ahmed.habib.petcare.ui.theme.Grey6

@Composable
fun OnboardingBaseScreen(
    circleIcon: Int,
    screenContent: @Composable () -> Unit,
) {

    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(brush = Brush.verticalGradient(colors = listOf(Grey5, Grey6)))
    ) {

        val (dogImage, card, circleImage) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(dogImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Card(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(
                        start = 24.dp,
                        top = 48.dp,
                        end = 24.dp,
                        bottom = 24.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                screenContent()
            }
        }

        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.White, shape = CircleShape)
                .constrainAs(circleImage) {
                    top.linkTo(card.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(card.top)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(circleIcon),
                contentDescription = "Circle Icon",
                tint = Blue1
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewScreen() {
    DashboardScreen()
}