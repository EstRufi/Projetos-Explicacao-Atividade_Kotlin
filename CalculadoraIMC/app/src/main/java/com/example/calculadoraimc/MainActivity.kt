package com.example.calculadoraimc

import androidx.compose.runtime.remember
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaImc(modifier = Modifier .padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaImc(modifier: Modifier = Modifier) {
    var textAltura by remember {
        mutableStateOf("")
    }
    var textPeso by remember {
        mutableStateOf("")
    }
    var resultado by remember {
        mutableStateOf(0.0)
    }
    Column(modifier = Modifier .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
//      --Header--
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(color = colorResource(R.color.cor_app)),
                    horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.bmi),
                contentDescription = "Logo APP",
                modifier = Modifier
                    .size(80.dp)
                    .padding(vertical = 16.dp)
            )

            Text(
                text = "Calculadora IMC",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

//      --Formulário --
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .offset(y = (-30).dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF8F6F6)
                ),
                elevation = CardDefaults.cardElevation(4.dp),
                //shape = CircleShape, Deixa redondo
                //border = BorderStroke(2.dp, Color.Black), Coloca borda
            ) {
                Column(modifier = Modifier
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Seus Dados",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.cor_app)
                    )

                    OutlinedTextField(
                        value = textAltura,
                        onValueChange = {textAltura = it
                            Log.i("",textAltura)},
                        singleLine = true,
                        label = {Text("Altura (em Metros)")},
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(R.color.cor_app),
                            unfocusedBorderColor = colorResource(R.color.cor_app)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )

                    OutlinedTextField(
                        value = textPeso,
                        onValueChange = {textPeso = it
                            Log.i("",textPeso)},
                        singleLine = true,
                        label = {Text("peso")},
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(R.color.cor_app),
                            unfocusedBorderColor = colorResource(R.color.cor_app)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    Button(
                        onClick = {
                            var classIMC = CalculandoIMC(textAltura,textPeso)
                            resultado = classIMC.calculando()

                        },
                        modifier = Modifier
                            .width(290.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.cor_app),
                        )
                    ) {
                        Text(
                            text = "Calcular",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }// EU POSSO USAR UTILIZANDO ALGO CHAMADO DATA CLASS OU O JSON

            //var corFundo = Color(87, 155, 111 )

           //corFundo = mudarCorCar(resultado)

//                  --Card Resultado --
            Card(modifier = Modifier
                .width(600.dp)
                .height(100.dp),
                colors = CardDefaults.cardColors(
//                    containerColor = corFundo
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text("${String.format("%.2f",resultado)}")
            }
        }
    }
}
// Matheus

//@Composable
//fun mudarCorCar(imc: Double): Color {
//    var cor: Color = Color.Gray
//    if(imc == 0.0){
//        cor = Color(130, 152, 225, 255)
//    }
//    else if (imc < 18.5){
//        cor = Color(255, 0, 0, 255)
//    }else if(imc < 25){
//        cor = Color(87, 155, 111 )
//    }else if(imc < 30){
//       cor = Color(255, 114, 0, 255)
//    }else if(imc < 35){
//        cor = Color(255, 0, 0, 255)
//    }else if(imc < 40){
//        cor = Color(255, 0, 0, 255)
//    }else if(imc > 40){
//        cor = Color(255, 0, 0, 255)
//    }
//
//    return  cor
//}