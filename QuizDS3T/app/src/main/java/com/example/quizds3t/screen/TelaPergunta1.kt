package com.example.quizds3t.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizds3t.R
import com.example.quizds3t.componente.CaixaDeNumeroDePerguntas
import com.example.quizds3t.componente.CardPergunta

@Composable
fun TelaPergunta1Screen(navController: NavController) {
    Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFEF98D0)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 25.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "Um icon de quiz",
            modifier = Modifier .size(100.dp)
        )

        CaixaDeNumeroDePerguntas(
            "Pergunta 1 de 3"
        )

        CardPergunta(
            pergunta = "Durante o curso, quem é a pessoa mais engraçado?",
            alternativas = arrayListOf("Fernando", "Francisco", "Samuel", "Jerffeson")
        )
    }
}