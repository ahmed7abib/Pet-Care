package com.ahmed.habib.petcare.features.dashboard

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun DashboardScreen() {

    var drawerState by remember { mutableStateOf(CustomDrawerState.Closed) }
    var selectedNavigationItem by remember { mutableStateOf(NavigationItem.Home) }

    val density = LocalDensity.current.density
    val screenWidth = LocalConfiguration.current.screenWidthDp

    val screenWidthState = remember { derivedStateOf { (screenWidth * density).roundToInt() } }
    val offsetValue by remember { derivedStateOf { (screenWidthState.value / 3.5).dp } }

    val animatedOffsetX by animateDpAsState(
        targetValue = if (drawerState.isOpened()) offsetValue else 0.dp,
        label = "offsetX"
    )

    val animatedOffsetY by animateDpAsState(
        targetValue = if (drawerState.isOpened()) 135.dp else 0.dp,
        label = "offsetY"
    )

    val animatedScale by animateFloatAsState(
        targetValue = if (drawerState.isOpened()) 0.83f else 1f,
        label = "scale"
    )

    val dashboardShape = when {
        drawerState.isOpened() -> {
            RoundedCornerShape(16.dp)
        }

        else -> {
            RoundedCornerShape(0.dp)
        }
    }

    BackHandler(enabled = drawerState.isOpened()) { drawerState = CustomDrawerState.Closed }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        CustomSideMenu(
            selectedNavigationItem = selectedNavigationItem,
            onNavigationItemClick = { selectedNavigationItem = it },
            onCloseClick = { drawerState = CustomDrawerState.Closed }
        )

        DashboardContent(
            modifier = Modifier
                .fillMaxSize()
                .offset(x = animatedOffsetX, y = animatedOffsetY)
                .scale(animatedScale)
                .background(
                    color = Color.White,
                    shape = dashboardShape
                )
                .padding(24.dp),
            drawerStateValue = drawerState,
            onDrawerClick = { drawerState = it }
        )
    }
}