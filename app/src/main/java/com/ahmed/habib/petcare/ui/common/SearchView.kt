package com.ahmed.habib.petcare.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmed.habib.petcare.R

@Composable
fun SearchView(modifier: Modifier = Modifier) {

    var query by remember { mutableStateOf("") }
    val data = listOf("Apple", "Banana", "Cherry", "Date", "Grapes", "Orange")

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            leadingIcon = Image(
                painter = painterResource(R.drawable.search),
                contentDescription = null
            ),
            value = query,
            onValueChange = { query = it },
            placeholder = { Text("Search...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}