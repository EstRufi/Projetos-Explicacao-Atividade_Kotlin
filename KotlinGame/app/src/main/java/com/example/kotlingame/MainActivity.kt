package com.example.kotlingame

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlingame.ui.theme.KotlinGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color.Black)) {
                        //ComponentesTela()

                        // Segunda tela
                        TelaGameOver()
                    }
                }
            }
        }
    }
}

@Composable
fun ComponentesTela (modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        RowInicial()
        RowAndroidsMals()
        ColumnStartGame()
    }
}

@Composable
fun TelaGameOver(modifier: Modifier = Modifier){


    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        RowAndroidsMals()

        Text(
            text = "GAME OVER",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 66.sp
        )
    }
}

@Composable
fun RowInicial (modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .padding(10.dp, 30.dp)
    ) {
        Text(
            text = "SCORE: 0050",
            color = Color.White,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "LIVES:",
                color = Color.White,

            )
            ImgVIda(modifier = Modifier,
                Color.Green
            )
        }

    }
}

@Composable
fun ImgVIda (modifier: Modifier = Modifier,
    color: Color
){
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android",
        modifier = Modifier.width(30.dp)
    )
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android",
        modifier = Modifier.width(30.dp)
    )
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android",
        modifier = Modifier.width(30.dp)
    )
}

@Composable
fun RowAndroidsMals (modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 30.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp, alignment = Alignment.CenterHorizontally)
    ) {

        val cor = listOf(
            Color.Green, Color.Red, Color.Blue, Color.Yellow, Color.Green
        )

        for (cores in cor) {
            Image(
                modifier = modifier.size(70.dp),
                painter = painterResource(R.drawable.android_robot),
                colorFilter = ColorFilter.tint(cores),
                contentDescription = "Android",
            )
        }

        // Da forma manual
//        ImgMobs(modifier = Modifier ,Color.Green)
//
//        ImgMobs(modifier = Modifier ,Color.Red)
//
//        ImgMobs(modifier = Modifier ,Color.Blue)
//
//        ImgMobs(modifier = Modifier ,Color.Yellow)
//
//        ImgMobs(modifier = Modifier ,Color.Green)

    }
}



@Composable
fun ColumnStartGame(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        ImgNave()
        Row(modifier = Modifier
            .background(Color(0xFF4F4F4F))
            .fillMaxWidth()
            .height(40.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "PRESS START",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ImgNave(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier .size(200.dp),
        painter = painterResource(R.drawable.img_kotlin),
        contentDescription = "Kotlin",
    )
}