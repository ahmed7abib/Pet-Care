package com.ahmed.habib.petcare.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ahmed.habib.petcare.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit,
) {

    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFAFAFA),
                        Color(0xFFD9D9D9)
                    )
                )
            )
    ) {
        val (logoImage, dogImage) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.buddy),
            contentDescription = "Splash Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(48.dp)
                .constrainAs(logoImage) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.dog_cropped),
            contentDescription = "Dog",
            modifier = Modifier
                .constrainAs(dogImage) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    height = androidx.constraintlayout.compose.Dimension.fillToConstraints
                }
        )
    }
}