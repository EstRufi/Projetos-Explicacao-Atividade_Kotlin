package com.example.composeestado

import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
    //variaveis
    val textoInput = remember {
        mutableStateOf("")
    }

    val quantidade = remember {
        mutableStateOf("")
    }
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

       TextField(
           modifier = Modifier.fillMaxWidth(),
           value = textoInput.value,
           onValueChange = { novoValor ->
               // da para usar sem isso
               // Log.i("Text", novoValor)
               textoInput.value = novoValor
           },
           keyboardOptions = KeyboardOptions( // nos estamos modificando as teclas
               keyboardType = KeyboardType.Number, //= é para o teclado aparecer como se fosse senha
           ),
           placeholder = {
               Text("qual a quantidade?")
           },
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = quantidade.value,
            onValueChange = { novoValor ->

                quantidade.value = novoValor
            },
            keyboardOptions = KeyboardOptions( // nos estamos modificando as teclas
                // keyboardType = KeyboardType.Password, = é para o teclado aparecer como se fosse senha
                capitalization = KeyboardCapitalization.Sentences
            ),
            label = {
                Text("Texte")
            }
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