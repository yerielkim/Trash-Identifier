package com.yerirang27.natureapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.yerirang27.natureapp.ui.theme.NatureAppTheme
import kotlin.random.Random

class CorrectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureAppTheme {
                window.decorView.announceForAccessibility("You are correct! Click next question")
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
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val context = LocalContext.current
                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(R.drawable.sun_gif)
                                .decoderFactory(GifDecoder.Factory())
                                .build(),
                            contentDescription = "Funny GIF",
                            modifier = Modifier.size(200.dp)
                        )
                        Text(
                            text = "YOU ARE CORRECT!",
                            color = Color.Black,
                            lineHeight = 50.sp,
                            fontSize = FontSize.content.value,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

//                        Text(
//                            text = "You saved our environment",
//                            color = Color.Black,
//                            fontSize = FontSize.content.value,
////                        fontWeight = FontWeight.Bold,
//                            lineHeight = 30.sp,
//                            modifier = Modifier.padding(16.dp),
//                            textAlign = TextAlign.Center,
//                            //                            modifier = Modifier.background(color = Color.Blue)
//                        )

                        Image(
                            painter = painterResource(id = R.drawable.nature),
                            contentDescription = "Nature",
                            modifier = Modifier.size(250.dp)
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier.fillMaxSize()
                        )

//                        Text(
//                            text = "GREAT JOB",
//                            color = Color.Black,
//                            fontSize = FontSize.content.value,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(16.dp),
//                            textAlign = TextAlign.Center,
//                            //                            modifier = Modifier.background(color = Color.Blue)
//                        )

                        Button(
                            onClick = {
                                val intent = Intent(this@CorrectActivity, GameActivity::class.java)
                                startActivity(intent)
//                                val range1 = 0..(QuizBank.currentIndex-1)
//                                val range2 = QuizBank.currentIndex+1..14
//                                val combinedList = range1.toList() + range2.toList()
//                                QuizBank.currentIndex = combinedList.random()
                                QuizBank.currentIndex++
                            },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF81C784),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Next question",
                                fontSize = FontSize.content.value,
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    bottom = 5.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
