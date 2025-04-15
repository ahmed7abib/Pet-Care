package com.ahmed.habib.petcare.ui.common

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.ahmed.habib.petcare.R


fun getCatamaranFont() = FontFamily(Font(R.font.catamaran_bold, weight = FontWeight.Normal))
fun getNotoSansFont() = FontFamily(Font(R.font.noto_sans_medium, weight = FontWeight.Normal))

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}