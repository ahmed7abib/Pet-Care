package com.ahmed.habib.petcare.features.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.habib.petcare.R

@Composable
fun GetStartedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFAFAFA), Color(0xFFD9D9D9)
                    )
                )
            )
    ) {

        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.62f)
                .align(Alignment.BottomCenter),
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.94f)
                    .align(Alignment.BottomCenter),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(3) { index ->
                            val color = if (index == 1) Color(0xFFFFC107) else Color(0xFFE0E0E0)

                            Box(
                                modifier = Modifier
                                    .height(4.dp)
                                    .width(50.dp)
                                    .background(color, shape = RoundedCornerShape(2.dp))
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Personalized Pet Profiles",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.W700,
                        fontFamily = getCatamaranFont(),
                        color = Color(0xFF39434F),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Create personalized profiles for each of your beloved pets on PawBuddy. Share their name, breed, and age while connecting with a vibrant community.",
                        fontSize = 16.sp,
                        fontFamily = getNotoSansFont(),
                        fontWeight = FontWeight.W500,
                        color = Color(0xFF808B9A),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { /* TODO */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007BFF)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Get started", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Sign up later",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                }
            }

            Box(
                modifier = Modifier
                    .size(75.dp)
                    .background(Color.White, shape = CircleShape)
                    .align(Alignment.TopCenter),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.edit_icon),
                    contentDescription = "Edit",
                    tint = Color(0xFF007BFF)
                )
            }
        }
    }
}

fun getCatamaranFont() = FontFamily(Font(R.font.catamaran_bold, weight = FontWeight.Normal))
fun getNotoSansFont() = FontFamily(Font(R.font.noto_sans_medium, weight = FontWeight.Normal))

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewScreen() {
    GetStartedScreen()
}