package com.example.quizds3t.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizds3t.R
import com.example.quizds3t.componente.CaixaDeNumeroDePerguntas
import com.example.quizds3t.componente.CardPergunta

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaPergunta2Screen(modifier: Modifier = Modifier) {
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
            "Pergunta 2 de 3"
        )

        CardPergunta(
            pergunta = "No curso quem é a pessoa mais Tímida?",
            alternativas = arrayListOf("Lucas", "Evellyn", "Gabriel(Biel)", "Alice")
        )
    }
}