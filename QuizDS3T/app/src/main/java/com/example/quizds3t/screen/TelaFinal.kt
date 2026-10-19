package com.example.quizds3t.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizds3t.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaFinalScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFD1EE)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 25.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.quiz),
            contentDescription = "Um Icom de quiz de 4 cores para cada letra",
            modifier = Modifier
                .size(100.dp)
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color(0xff83D8F7)),
            verticalArrangement = Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier .height(40.dp)
                    .width(150.dp),
                border = BorderStroke(1.dp,Color.Black)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF89D5A7)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Bem Legal!!"
                    )
                }

            }

            Text(
                text = "aa"
            )
        }

        Button(
            onClick = {},
            modifier = Modifier .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp,Color.Black)
        ) {
            Text(
                text = "JOGAR NOVAMENTE",
                fontSize = 20.sp
            )
        }
    }
}
