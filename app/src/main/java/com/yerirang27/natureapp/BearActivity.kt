package com.yerirang27.natureapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.yerirang27.natureapp.ui.theme.NatureAppTheme


// Lottie -> AirBnb - Third party library
class BearActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NatureAppTheme {
                window.decorView.announceForAccessibility("The Earth will warm up, destroying homes of animals and hurting the animals! This is called climate change and we we need to stop it! Click return to go back")

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
                            text = "The Earth will warm up, destroying homes of animals and hurting the animals!",
                            color = Color.DarkGray,
                            fontSize = FontSize.content.value,
//                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(1.dp),
                            lineHeight = 30.sp,
                            textAlign = TextAlign.Center,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.hot_earth),
                            contentDescription = "hot earth",
                            modifier = Modifier.size(250.dp)
                        )

                        Text(
                            text = "This is called climate change\n" +
                                    "And we need to stop it!",
                            color = Color.DarkGray,
                            fontSize = FontSize.content.value,
//                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(1.dp),
                            lineHeight = 30.sp,
                            textAlign = TextAlign.Center,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )


                        Button(
                            onClick = {
                                val intent = Intent(this@BearActivity, WrongActivity::class.java)
                                startActivity(intent)
                                //Toast.makeText(this@BearActivity, "Button Clicked!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
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
