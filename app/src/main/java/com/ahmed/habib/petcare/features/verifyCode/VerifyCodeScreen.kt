package com.ahmed.habib.petcare.features.verifyCode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.features.onBoarding.OnboardingBaseScreen
import com.ahmed.habib.petcare.ui.common.getCatamaranFont
import com.ahmed.habib.petcare.ui.common.getNotoSansFont
import com.ahmed.habib.petcare.ui.theme.Blue1
import com.ahmed.habib.petcare.ui.theme.Grey2
import com.ahmed.habib.petcare.ui.theme.Grey3
import com.ahmed.habib.petcare.ui.theme.Grey4

@Composable
fun VerifyCodeScreen(
    onConfirmBtnClicked: () -> Unit,
) {

    OnboardingBaseScreen(
        circleIcon = R.drawable.scan,
    ) {

        Text(
            text = stringResource(R.string.validation_code),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = getCatamaranFont(),
            color = Grey3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.check_your_email_inbox_and_enter_the_validation_code_here),
            fontSize = 14.sp,
            color = Grey2,
            fontFamily = getNotoSansFont(),
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        VerificationCodeInput { code -> verify(code) }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onConfirmBtnClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Blue1)
        ) {
            Text(
                text = stringResource(R.string.confirm),
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = getNotoSansFont(),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = stringResource(R.string.did_not_receive_the_code),
                color = Grey4,
                fontFamily = getNotoSansFont(),
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )

            Text(
                text = stringResource(R.string.resend),
                color = Blue1,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = getNotoSansFont(),
                modifier = Modifier.clickable { onResendBtnClicked() }
            )
        }
    }
}

@Composable
fun VerificationCodeInput(
    onCodeComplete: (String) -> Unit,
) {

    val numberOfDigits = 6
    var code by remember { mutableStateOf(List(numberOfDigits) { "" }) }
    val focusRequesters = remember { List(numberOfDigits) { FocusRequester() } }

    Row {
        for (i in 0 until numberOfDigits) {
            OutlinedTextField(
                value = code[i],
                onValueChange = { newValue ->
                    if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                        val newCode = code.toMutableList()
                        newCode[i] = newValue
                        code = newCode

                        when {
                            newValue.isNotEmpty() && i < numberOfDigits - 1 -> {
                                focusRequesters[i + 1].requestFocus()
                            }

                            newValue.isEmpty() && i > 0 -> {
                                focusRequesters[i - 1].requestFocus()
                            }
                        }

                        if (code.all { it.isNotEmpty() }) {
                            onCodeComplete(code.joinToString(""))
                        }
                    }
                },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontFamily = getNotoSansFont(),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequesters[i])
                    .focusProperties {
                        if (i > 0) previous = focusRequesters[i - 1]
                        if (i < numberOfDigits - 1) next = focusRequesters[i + 1]
                    },
                shape = RoundedCornerShape(12.dp)
            )

            if (i < numberOfDigits - 1) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

private fun verify(code: String) {
    // todo: verify
}

private fun onResendBtnClicked() {
    // todo: resend
}
