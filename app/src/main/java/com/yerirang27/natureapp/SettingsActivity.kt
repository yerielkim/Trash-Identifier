package com.yerirang27.natureapp

import android.content.Context
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
class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("settings_prefs", Context.MODE_PRIVATE)
        // Load the saved font size preference
        val savedFontSize = sharedPreferences.getString("font_size", "default")
        setContent {
            NatureAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var currentFont by remember { mutableStateOf(savedFontSize) }
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(16.dp),
//                            horizontalArrangement = Arrangement.SpaceEvenly
////                            verticalArrangement = Arrangement.SpaceEvenly
//                        ) {
                        Text(
                            text = "Font Size",
                            color = Color.Black,
                            fontSize = FontSize.title.value,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center,
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

                        Text(
                            text = "The current font is $currentFont",
                            color = Color.Black,
                            fontSize = FontSize.content.value,
//                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center,
                            lineHeight = FontSize.content.value
                            //                            modifier = Modifier.background(color = Color.Blue)
                        )

                        Button(
                            onClick = {
                                currentFont = "default"
                                // Save the preference in SharedPreferences
                                with(sharedPreferences.edit()) {
                                    putString("font_size", "default")
                                    apply()
                                }
                                FontSize.init(this@SettingsActivity)
                            },
                            //modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF81C784),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Default",
                                fontSize = FontSize.content.value,
                                modifier = Modifier.padding(
                                    horizontal = 25.dp,
                                    vertical = 8.dp
                                )
                            )
                        }
                        Button(
                            onClick = {
                                currentFont = "large"
                                // Save the preference in SharedPreferences
                                with(sharedPreferences.edit()) {
                                    putString("font_size", "large")
                                    apply()
                                }
                                FontSize.init(this@SettingsActivity)
                            },
                            //modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF81C784),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Large",
                                fontSize = FontSize.content.value,
                                modifier = Modifier.padding(
//                                    top = 5.dp,
//                                    bottom = 5.dp,
                                    horizontal = 25.dp,
                                    vertical = 8.dp
                                )
                            )
                        }
                        Button(
                            onClick = {
                                val intent = Intent(this@SettingsActivity, HomeActivity::class.java)
                                startActivity(intent)
                                //Toast.makeText(this@BearActivity, "Button Clicked!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF388E3C),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Return",
                                fontSize = FontSize.content.value,
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    bottom = 5.dp
                                )
                            )
                        }

//                        }


                    }




                }
            }
        }
    }
}
