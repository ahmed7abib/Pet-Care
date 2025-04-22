package com.ahmed.habib.petcare.features.add_pet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.ui.common.getCatamaranFont
import com.ahmed.habib.petcare.ui.theme.Grey1
import com.ahmed.habib.petcare.ui.theme.Grey2
import com.ahmed.habib.petcare.ui.theme.Grey8
import com.ahmed.habib.petcare.ui.theme.Yellow

@Composable
fun AddPetProfileBaseScreen(
    currentScreen: @Composable () -> Unit,
) {

    val scrollState = rememberScrollState()
    var progress by remember { mutableIntStateOf(3) }

    Scaffold(
        topBar = { Header(progress, "Test") },
        bottomBar = { Footer() },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            currentScreen()
        }
    }
}

@Composable
fun Header(progress: Int, screenName: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .drawBehind {
                drawRect(
                    color = Grey2.copy(alpha = 0.1f),
                    topLeft = Offset(0f, size.height - 4.dp.toPx()),
                    size = Size(size.width, 4.dp.toPx())
                )
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 26.dp, horizontal = 24.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back Btn",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { back() },
                    colorFilter = ColorFilter.tint(color = Grey2),
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        stringResource(R.string.add_pet_profile),
                        color = Grey1,
                        fontFamily = getCatamaranFont(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Text(
                        screenName,
                        color = Grey2,
                        fontWeight = FontWeight.Light,
                        fontFamily = getCatamaranFont(),
                        fontSize = 14.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        stringResource(R.string.step),
                        color = Grey2,
                        fontFamily = getCatamaranFont(),
                        fontSize = 12.sp
                    )

                    Text(
                        "${progress}/9",
                        color = Grey2,
                        fontFamily = getCatamaranFont(),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            val maxProgress = 9f
            val progressValue = progress / maxProgress

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Yellow,
                trackColor = Grey8,
                progress = { progressValue },
            )
        }
    }
}

private fun back() {
}

@Composable
fun Footer() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Cancel")
        Text(text = "Save")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPetProfile() {
    AddPetProfileBaseScreen({})
}