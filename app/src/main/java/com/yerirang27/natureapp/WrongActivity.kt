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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
class WrongActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureAppTheme {
                val rightAnswer = intent.getStringExtra("RIGHT_ANSWER") ?: "[right answer]"
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
                            text = "Not quite...",
                            color = Color.DarkGray,
                            fontSize = FontSize.title.value,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(1.dp),
                            textAlign = TextAlign.Center,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

                        Text(
                            text = "You should throw it in the $rightAnswer bin!",
                            color = Color.DarkGray,
                            fontSize = FontSize.content.value,
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = FontSize.content.value
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

                        Text(
                            text = "Click on the images",
                            color = Color.DarkGray,
                            fontSize = FontSize.content.value,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = FontSize.content.value
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )
                        Spacer(modifier = Modifier.height(1.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
//                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.seals_pic),
                                contentDescription = "seals_pic",
                                modifier = Modifier
                                    .size(ImageSize.image)
                                    .border(width = 4.dp, color = Color.Black)
                                    .clickable {
                                        val intent =
                                            Intent(this@WrongActivity, SealsActivity::class.java)
                                        startActivity(intent)
                                        Toast.makeText(
                                            this@WrongActivity,
                                            "Seal image Clicked!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                            )
                            Spacer(modifier = Modifier.height(1.dp))
                            Image(
                                painter = painterResource(id = R.drawable.polarbear_cc),
                                contentDescription = "Polarbear_cc",
                                modifier = Modifier

                                    .size(ImageSize.image)
                                    .border(width = 4.dp, color = Color.Black)
                                    .clickable {
                                        val intent =
                                            Intent(this@WrongActivity, BearActivity::class.java)
                                        startActivity(intent)
                                    }
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier.fillMaxSize()
                            )
                        }

                        Button(
                            onClick = {
                                val intent = Intent(this@WrongActivity, GameActivity::class.java)
                                startActivity(intent)
                                QuizBank.currentIndex++
                            },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF81C784),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Next question",
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
