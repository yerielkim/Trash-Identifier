package com.yerirang27.natureapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Singleton
object ImageSize {
    var image = 200.dp

    fun init(context: Context) {
        val sharedPreferences = context.getSharedPreferences("settings_prefs", Context.MODE_PRIVATE)
        // Load the saved font size preference
        val savedFontSize = sharedPreferences.getString("font_size", "default")

        if (savedFontSize == "default") {
            image = 120.dp
        } else {
            image = 200.dp
        }
    }
}

