package com.ahmed.habib.petcare.ui.common

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.habib.petcare.ui.theme.Blue1
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeButton(
    icon: Int,
    btnName: String,
    textColor: Color,
    modifier: Modifier = Modifier,
    onSwipeComplete: () -> Unit,
) {

    val thumbSize = 55.dp
    val swipeWidth = (LocalConfiguration.current.screenWidthDp.dp - thumbSize)
    val maxOffsetPx = with(LocalDensity.current) { (swipeWidth - thumbSize).toPx() }

    val swipeState = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    val dragState = rememberDraggableState { delta ->
        coroutineScope.launch {
            val newValue = (swipeState.value + delta).coerceIn(0f, maxOffsetPx)
            swipeState.snapTo(newValue)
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = btnName,
            color = textColor,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 16.sp
        )

        Box(
            modifier = Modifier
                .offset { IntOffset(swipeState.value.roundToInt(), 0) }
                .size(thumbSize)
                .padding(6.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Blue1)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = dragState,
                    onDragStopped = {
                        coroutineScope.launch {
                            if (swipeState.value >= maxOffsetPx * 0.9f) {
                                swipeState.animateTo(maxOffsetPx)
                                onSwipeComplete()
                            } else {
                                swipeState.animateTo(0f)
                            }
                        }
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                modifier = Modifier
                    .width(20.dp)
                    .fillMaxHeight(),
                contentDescription = null,
            )
        }
    }
}