package com.yerirang27.natureapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.sp

// Singleton
object FontSize {
    var title = mutableStateOf(50.sp)
    var heading = mutableStateOf(40.sp)
    var content = mutableStateOf(30.sp)

    fun init(context: Context) {
        val sharedPreferences = context.getSharedPreferences("settings_prefs", Context.MODE_PRIVATE)
        // Load the saved font size preference
        val savedFontSize = sharedPreferences.getString("font_size", "default")

        if (savedFontSize == "default") {
            title.value = 60.sp
            heading.value = 40.sp
            content.value = 35.sp
        } else {
            title.value = 65.sp
            heading.value = 50.sp
            content.value = 40.sp
        }
    }
}