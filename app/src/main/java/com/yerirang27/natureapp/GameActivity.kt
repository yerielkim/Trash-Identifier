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
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.yerirang27.natureapp.ui.theme.NatureAppTheme


class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                                text = "Game",
                                color = Color.Black,
                                fontSize = FontSize.title.value,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center,
                                //                            modifier = Modifier.background(color = Color.Blue)
                            )

                            Text(
                                text = "Where does this go?",
                                color = Color.Black,
                                fontSize = FontSize.content.value,
//                        fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center,
                                lineHeight = FontSize.content.value
                                //                            modifier = Modifier.background(color = Color.Blue)
                            )

                        AsyncImage(
                            model = QuizBank.currentQuestion.image,
                            contentDescription = QuizBank.currentQuestion.contentDescription,
                            modifier = Modifier.size(250.dp)
                        )

//                            Image(
//                                painter = painterResource(id = R.drawable.banana_peel),
//                                contentDescription = "Banana peel",
//                                modifier = Modifier.size(300.dp)
////                            contentScale = ContentScale.FillBounds,
////                            modifier = Modifier.fillMaxSize()
//                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly
//                            verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.recycle),
                                    contentDescription = "Recycle",
                                    modifier = Modifier
                                        .border(width = 4.dp, color = Color.Black)
                                        .size(100.dp)
                                        .clickable {
                                            if (QuizBank.currentQuestion.answer != "Recycle"){
                                                val intent =
                                                    Intent(this@GameActivity, WrongActivity::class.java)
                                                intent.putExtra("RIGHT_ANSWER", QuizBank.currentQuestion.answer)
                                                startActivity(intent)
                                            }else{
                                                val intent =
                                                    Intent(this@GameActivity, CorrectActivity::class.java)
                                                startActivity(intent)
                                            }


                                        }
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier.fillMaxSize()
                                )



                                Image(
                                    painter = painterResource(id = R.drawable.trash),
                                    contentDescription = "Trash",
                                    modifier = Modifier
                                        .border(width = 4.dp, color = Color.Black)
                                        .size(100.dp)
                                        .clickable {
                                            if (QuizBank.currentQuestion.answer != "Trash"){
                                                val intent =
                                                    Intent(this@GameActivity, WrongActivity::class.java)
                                                intent.putExtra("RIGHT_ANSWER", QuizBank.currentQuestion.answer)
                                                startActivity(intent)
                                            }else{
                                                val intent =
                                                    Intent(this@GameActivity, CorrectActivity::class.java)
                                                startActivity(intent)
                                            }

                                        }
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier.fillMaxSize()
                                )


                                Image(
                                    painter = painterResource(id = R.drawable.compost),
                                    contentDescription = "Compost",
                                    modifier = Modifier
                                        .border(width = 4.dp, color = Color.Black)
                                        .size(100.dp)
                                        .clickable {
                                            if (QuizBank.currentQuestion.answer != "Compost"){
                                                val intent =
                                                    Intent(this@GameActivity, WrongActivity::class.java)
                                                intent.putExtra("RIGHT_ANSWER", QuizBank.currentQuestion.answer)
                                                startActivity(intent)
                                            }else{
                                                val intent =
                                                    Intent(this@GameActivity, CorrectActivity::class.java)
                                                startActivity(intent)
                                            }
                                        }
//                            contentScale = ContentScale.FillBounds,
//                            modifier = Modifier.fillMaxSize()
                                )


                            }

                            Spacer(modifier = Modifier.height(1.dp))

                            Button(
                                onClick = {
                                    val intent = Intent(this@GameActivity, HomeActivity::class.java)
                                    startActivity(intent)
                                    Toast.makeText(
                                        this@GameActivity,
                                        "Button Clicked!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
//                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF81C784),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(
                                    text = "End game",
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
