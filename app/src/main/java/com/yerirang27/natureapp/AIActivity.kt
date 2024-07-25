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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yerirang27.natureapp.ui.theme.NatureAppTheme


class AIActivity : ComponentActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && data!=null && data.getExtras()!=null) {
            val intent = Intent(this, AIDetailActivity::class.java)
            intent.putExtras(data)
            startActivity(intent)
        }

        super.onActivityResult(requestCode,resultCode,data);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 1)
        }

        QuizBank.createQuizBank()
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
                                text = "What do you want to throw away?",
                                color = Color.Black,
                                fontSize = FontSize.title.value,
                                fontWeight = FontWeight.Bold,
                                lineHeight = FontSize.title.value,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center,
                                //                            modifier = Modifier.background(color = Color.Blue)
                            )

                            Text(
                                text = "Take a picture",
                                color = Color.Black,
                                fontSize = FontSize.content.value,
//                        fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center,
                                lineHeight = FontSize.content.value
                                //                            modifier = Modifier.background(color = Color.Blue)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.camera_icon),
                                contentDescription = "Camera",
                                modifier = Modifier
                                    .size(250.dp)
                                    .clickable {
                                        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                                        startActivityForResult(cameraIntent, 1)
                                    }
                            )


                            Button(
                                onClick = {
                                    val intent = Intent(this@AIActivity, HomeActivity::class.java)
                                    startActivity(intent)

                                },
//                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
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
