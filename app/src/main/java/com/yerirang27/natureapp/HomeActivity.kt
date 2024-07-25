package com.yerirang27.natureapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yerirang27.natureapp.ui.theme.NatureAppTheme


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FontSize.init(this)
        setContent {
            NatureAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.sunny_field),
                            contentDescription = "Nature picture",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )

                        Column (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            //                        Text(
                            //                            text = "Home Page",
                            //                            modifier = Modifier.padding(
                            //                                start = 12.dp,
                            //                                top = 12.dp,
                            //                                bottom = 12.dp
                            //                            )
                            //                        )
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(
                                        color = Color(0xFF90CAF9), // Background color
                                        shape = RoundedCornerShape(16.dp) // Rounded corners
                                    )
                                    .padding(16.dp), // Padding inside the box
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "Home Page",
                                    color = Color(0xFF1976D2),
                                    fontSize = FontSize.title.value,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(16.dp),
                                    textAlign = TextAlign.Center,
                                    lineHeight = FontSize.title.value

                                    //                            modifier = Modifier.background(color = Color.Blue)
                                )
                            }

                            var count by remember {
                                mutableStateOf(0)
                            }

                            Button(
                                onClick = {
                                    val intent = Intent(this@HomeActivity, GameActivity::class.java)
                                    startActivity(intent)
                                    Toast.makeText(this@HomeActivity, "Button Clicked!", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF81C784),
                                    contentColor = Color.White
                                ),
                                border = BorderStroke(5.dp, Color.DarkGray)
                            ) {
                                Text(
                                    text = "Game",
                                    fontSize = FontSize.content.value,
                                    modifier = Modifier.padding(
                                        top = 15.dp,
                                        bottom = 15.dp
                                    )
                                )
                            }

                            Button(
                                onClick = {
                                    val intent = Intent(this@HomeActivity, AIActivity::class.java)
                                    startActivity(intent)
                                },
                                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF81C784),
                                    contentColor = Color.White
                                ),
                                border = BorderStroke(5.dp, Color.DarkGray)
                            ) {
                                Text(
                                    text = "Recycle Identifier",
                                    fontSize = FontSize.content.value,
                                    modifier = Modifier.padding(
                                        top = 15.dp,
                                        bottom = 15.dp
                                    ),
                                    textAlign = TextAlign.Center,
                                    lineHeight = FontSize.content.value
                                )
                            }

                            val buttonShape = RoundedCornerShape(8.dp)

                            Box {
                                Button(
                                    onClick = {
                                        val intent = Intent(this@HomeActivity, SettingsActivity::class.java)
                                        startActivity(intent)
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF81C784),
                                        contentColor = Color.White
                                    ),
                                    border = BorderStroke(5.dp, Color.DarkGray)
                                ) {
                                    Text(
                                        text = "Settings",
                                        fontSize = FontSize.content.value,
                                        modifier = Modifier.padding(
                                            top = 15.dp,
                                            bottom = 15.dp
                                        )
                                    )
                                }
                            }
                        }
                    }


                    }
                }
            }
        }
    }

