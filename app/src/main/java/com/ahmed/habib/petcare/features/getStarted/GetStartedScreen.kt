package com.ahmed.habib.petcare.features.getStarted

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.features.onBoarding.OnboardingBaseScreen
import com.ahmed.habib.petcare.ui.getCatamaranFont
import com.ahmed.habib.petcare.ui.getNotoSansFont
import com.ahmed.habib.petcare.ui.theme.Blue
import com.ahmed.habib.petcare.ui.theme.Grey0
import com.ahmed.habib.petcare.ui.theme.Grey1
import com.ahmed.habib.petcare.ui.theme.Grey2
import com.ahmed.habib.petcare.ui.theme.Yellow

@Composable
fun GetStartedScreen() {

    OnboardingBaseScreen(
        circleIcon = R.drawable.edit_icon,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { index ->
                val color = if (index == 1) Yellow else Grey0

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
            text = stringResource(R.string.personalized_pet_profiles),
            fontSize = 26.sp,
            fontWeight = FontWeight.W700,
            fontFamily = getCatamaranFont(),
            color = Grey1,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.create_personalized_profiles_for_each_of_your_beloved_pets_on_pawbuddy_share_their_name_breed_and_age_while_connecting_with_a_vibrant_community),
            fontSize = 16.sp,
            fontFamily = getNotoSansFont(),
            fontWeight = FontWeight.W500,
            color = Grey2,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onGetStartedClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = stringResource(R.string.get_started),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.sign_up_later),
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onSignUpLaterClick() }
        )
    }
}

private fun onGetStartedClick() {
    // todo.
}

private fun onSignUpLaterClick() {
    // todo.
}