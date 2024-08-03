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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yerirang27.natureapp.ui.theme.NatureAppTheme

// Lottie -> AirBnb - Third party library
class SealsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureAppTheme {
                window.decorView.announceForAccessibility("Our animal friends will get hurt by our mistakes. They get trapped in plastic or become sick! Click return to go back.")
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
                        Text(
                            text = "Our animal friends will get hurt by our mistakes",
                            color = Color.DarkGray,
                            fontSize = FontSize.content.value,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(1.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = FontSize.content.value,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )
//                        Image(
//                            painter = painterResource(id = R.drawable.frowny_face),
//                            contentDescription = "frowny face",
//                            modifier = Modifier.size(100.dp),
//                        )

                        Text(
                            text = "They get trapped in plastic or become sick!",
                            color = Color.DarkGray,
                            fontSize = FontSize.content.value,
//                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(1.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = FontSize.content.value,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.polarbear_cc),
                            contentDescription = "bear",
                            modifier = Modifier.size(250.dp),
                        )

                        Button(
                            onClick = {
                                val intent = Intent(this@SealsActivity, WrongActivity::class.java)
                                startActivity(intent)
                                //Toast.makeText(this@BearActivity, "Button Clicked!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF81C784),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Return",
                                fontSize = FontSize.content.value,
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                            )
                        }

                    }
                }
            }
        }
    }
}
