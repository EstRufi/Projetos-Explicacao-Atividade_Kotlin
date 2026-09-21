package com.example.composeestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeestado.ui.theme.ComposeEstadoTheme
import com.example.composeestado.ui.theme.intel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color(239, 247, 200))
                        .fillMaxSize()) {
                        CriandoComponenteBasicScreen()

                    }
                }
            }
        }
    }
}

@Composable
fun CriandoComponenteBasicScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
    ) {
        Text(
            text = "Aulas Android",
            color = Color(0xFFA8EC59),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = intel,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "com JetPack Compose",
            color = Color(0xFF4E9AD9),
            fontSize = 12.sp,
            fontFamily = intel,
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )

        AndroidEnemy(modifier = Modifier
            .size(100.dp),
            Color.Red
        )
    }
}

@Composable
 fun AndroidEnemy(modifier: Modifier = Modifier,
                 color: Color) {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy"
    )
}