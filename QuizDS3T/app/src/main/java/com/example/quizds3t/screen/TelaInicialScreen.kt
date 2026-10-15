package com.example.quizds3t.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizds3t.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaInicialScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff83D8F7)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Image(
            painter = painterResource(id = R.drawable.quiz),
            contentDescription = "Um Icom de quiz de 4 cores para cada letra",
            modifier = Modifier
                .size(150.dp)
        )

        Text(
            text = "DS3TQuiz",

        )
        Text(
            text = "Você realmente conhece a DS3T? Vamos descobrir"
        )

        Button(
            onClick = {}
        ) {
            Text("Clica aqui para começar")
        }
    }
}
