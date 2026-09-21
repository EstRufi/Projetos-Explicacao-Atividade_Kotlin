package com.example.composekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composekotlin.ui.theme.ComposeKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column() {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Tem certeza que quer escrever aqui?")
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.outline_adb_24),
                    contentDescription = "Bebe android para o campo de busca"
                )
            }
        )
    }
}
