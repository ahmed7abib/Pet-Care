package com.ahmed.habib.petcare.features.register

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.features.onBoarding.OnboardingBaseScreen
import com.ahmed.habib.petcare.ui.common.getCatamaranFont
import com.ahmed.habib.petcare.ui.common.getNotoSansFont
import com.ahmed.habib.petcare.ui.common.showToast
import com.ahmed.habib.petcare.ui.theme.Blue1
import com.ahmed.habib.petcare.ui.theme.Grey2
import com.ahmed.habib.petcare.ui.theme.Grey3
import com.ahmed.habib.petcare.ui.theme.Grey4

@Composable
fun RegisterScreen(
    onCreateAccountClicked: () -> Unit,
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isTermsAccepted by remember { mutableStateOf(false) }
    val context = LocalContext.current

    OnboardingBaseScreen(
        circleIcon = R.drawable.account,
    ) {

        Text(
            text = stringResource(R.string.create_account),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = getCatamaranFont(),
            color = Grey3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.welcome_please_enter_your_information_below_and_get_started),
            fontSize = 14.sp,
            color = Grey2,
            fontWeight = FontWeight.Light,
            fontFamily = getNotoSansFont(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.your_email), fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.LightGray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                unfocusedIndicatorColor = Color.LightGray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Grey2
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.password), fontSize = 12.sp) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.LightGray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                unfocusedIndicatorColor = Color.LightGray,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Grey2
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = isTermsAccepted,
                onCheckedChange = { isTermsAccepted = it },
                modifier = Modifier
                    .size(20.dp)
                    .padding(start = 12.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Blue1,
                    uncheckedColor = Grey2
                )
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(R.string.accept_terms_and_conditions),
                fontSize = 12.sp,
                fontFamily = getNotoSansFont(),
                fontWeight = FontWeight.Light,
                color = Grey2
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onCreateAccountClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue1)
        ) {
            Text(
                text = stringResource(R.string.create_account),
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = getNotoSansFont(),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = stringResource(R.string.already_have_an_account),
                color = Grey4,
                fontFamily = getNotoSansFont(),
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )

            Text(
                text = stringResource(R.string.login_here),
                color = Blue1,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = getNotoSansFont(),
                modifier = Modifier.clickable { onLoginHereClicked(context) }
            )
        }
    }
}

private fun onLoginHereClicked(context: Context) {
    context.showToast("Todo: login")
}
