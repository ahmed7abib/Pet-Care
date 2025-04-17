package com.ahmed.habib.petcare.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.ui.theme.Grey5

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchView(
    text: String,
    onExitClick: () -> Unit,
    onValueChange: (String) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(Grey5, shape = RoundedCornerShape(16.dp))
    ) {
        TextField(
            value = text,
            onValueChange = { onValueChange(it) },
            placeholder = { Text(stringResource(R.string.search)) },
            modifier = Modifier
                .weight(2f)
                .wrapContentHeight(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            )
        )

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(22.dp)
                .background(Color.White, CircleShape)
                .border(1.dp, Color.Black, CircleShape)
                .padding(4.dp)
                .clickable {
                    onExitClick()
                    onValueChange("")
                },
        )
    }
}