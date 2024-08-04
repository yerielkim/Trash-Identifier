package com.yerirang27.natureapp

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.yerirang27.natureapp.ui.theme.NatureAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AIDetailActivity : ComponentActivity() {
    val chatGPTService = ChatGPTService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val state = mutableStateOf<Item?>(null)
        val image: Bitmap = intent.extras!!.get("data") as Bitmap
        lifecycleScope.launch(Dispatchers.IO) {
            state.value = chatGPTService.query(image)
        }
        setContent {
            NatureAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Captured image:",
                            fontSize = FontSize.content.value,
                        )
                        if (state.value  != null) {
                            Text(
                                text = "Recognized item: " + state.value!!.item,
                                fontSize = FontSize.content.value,
                            )
                            Text(
                                text = "It should go to: " + state.value!!.recycleMethod,
                                fontSize = FontSize.content.value,
                            )
                        }
                        Image(
                            bitmap = image.asImageBitmap(),
                            contentDescription = "Captured image",
                            modifier = Modifier.size(200.dp)
                        )
                    }
                }
            }
        }
    }
}
