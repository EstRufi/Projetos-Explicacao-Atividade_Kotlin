package com.example.verificadoidade

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.verificadoidade.ui.theme.VerificadoIdadeTheme
import kotlin.collections.plusAssign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VerificadoIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color(0Xfffafafa))
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        VerificadorIdade()
                    }
                }
            }
        }
    }
}


@Composable
fun VerificadorIdade(modifier: Modifier = Modifier) {


    var idade: Int by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual é sua idade?",
            fontSize = 30.sp,
            color = Color(0xff4857B7)
        )

        Text("Aperte os botões para informar a sua idade")

        Text(
            text = "$idade",
            fontSize = 30.sp,
            modifier = Modifier .padding(20.dp)
        )
        BotaoIdade(idade,{novaIdade ->
            if (novaIdade >-1 && novaIdade<181){
                idade = novaIdade
            }
        })

        if(idade >=18){
            Text(
                text = "Você é MAIOR de Idade",
                color = Color(0xff4857B7),
                fontSize = 30.sp,
                modifier = Modifier.padding(30.dp)
            )
        }
        else{
            Text(
                text = "Você é MENOR de Idade",
                color =Color(0xff4857B7),
                fontSize = 30.sp,
                modifier = Modifier.padding(30.dp)
            )
        }
//
//         MAtheus
//        Row() {
//            Button(
//                onClick = {
//                    if (idade >0) {
//                        idade -= 1
//                    }
//                }
//            ) {
//
//                Text("-")
//            }
//
//            Button(
//                onClick = {
//                    if (idade <=179) {
//                        idade += 1
//                    }
//                }
//            ) {
//
//                Text("+")
//            }
//
//
//        }


//        Text(
//            text = "Você é $statusIdade de idade"
//        )
//
//        if (idade>=18){
//            statusIdade = "MAIOR"
//        }else{
//            statusIdade = "MENOR"
//        }

    }
}

// EU
// Tem como fazer de outra forma, mostrará no futuro
@Composable
fun BotaoIdade (
    idade: Int,
    onMudarIdade:(Int) -> Unit
) {
    Row(modifier = Modifier .fillMaxWidth()
        .size(60.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        //if (valorIdade>0 || valorIdade<120) {
            Button(
                onClick ={onMudarIdade(idade - 1)},
                modifier = Modifier
                    .height(100.dp)
                    .width(90.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.menos),
                    contentDescription = "-"
                )
            }

            Button(
                onClick ={onMudarIdade(idade + 1)},
                modifier = Modifier
                    .height(100.dp)
                    .width(90.dp)

            ) {
                Image(
                    painter = painterResource(R.drawable.mais),
                    contentDescription = "+"
                )
            }
        //}
    }
}