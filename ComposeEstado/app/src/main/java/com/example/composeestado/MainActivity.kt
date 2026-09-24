package com.example.composeestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
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

    // o by serve para tirar o velue, nele o by vc usa para get e put
    var coresMudando by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetPack_Compouse by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember { mutableStateOf(0) }

    var corFundo by remember {
        mutableStateOf(Color(239, 247, 200))
    }

    var favoritado by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(corFundo)
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
            value = coresMudando,
            onValueChange = { novoValor ->
                coresMudando = novoValor
            },
            keyboardOptions = KeyboardOptions( // nos estamos modificando as teclas
                // keyboardType = KeyboardType.Password, = é para o teclado aparecer como se fosse senha
                capitalization = KeyboardCapitalization.Sentences
            ),
            placeholder = {
                Text("qual a quantidade?")
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Red, // quando tiver escrevendo
                unfocusedTextColor = Color.Blue,    // tiver escrever e não tiver digitando
                unfocusedPlaceholderColor = Color.Green // ninguem clicou ou precionou ele
            )
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
                Text("Nome e Sobrenome")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription =  "Pessoa",
                    tint = Color(40, 86, 178, 255),
                    modifier = modifier.size(30.dp)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription =  "Pessoa",
                    tint = Color(137, 40, 178, 255),
                    modifier = modifier.size(30.dp)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            singleLine = true, // diz que é so uma linha, se for false vc pode almentar ela
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email") },
            placeholder = {Text(text = "Digite seu email")},
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp,
                bottomStart = 32.dp,
                topEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Yellow,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.Red
            )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = {kotlin = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Magenta
                )
            )

            Text("Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jetPack_Compouse,
                onCheckedChange = {jetPack_Compouse = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.LightGray,
                    uncheckedColor = Color.Magenta
                )
            )

            Text("JetPacck Compouse")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = android,
                onCheckedChange = {android = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Magenta
                ),
            )

            Text("Android")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 0,
                onClick = {sistemaSelecionado = 0}
            )

            Text("MacOs")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = {sistemaSelecionado = 1}
            )

            Text("Linux")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = {sistemaSelecionado =2}
            )

            Text("Windows")
        }

        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color(0xFFCFB7FF)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Yellow
                ),
                border = BorderStroke(4.dp,Color.Black),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                    ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carro de Pobre",
                        modifier = modifier.size(30.dp)
                    )
                    Text(text = "Radadadnnnnandnan", fontSize = 15.sp)
                }
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color.Black
                }
            ) {
                Row() {
                    Text("É pobre vindo?")
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if(favoritado){
                Icon(
                    modifier = Modifier.size(50.dp)
                        .clickable{
                            favoritado = false
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorito"
                )
            }
            else{
                Icon(
                    modifier = Modifier.size(30.dp)
                        .clickable{
                            favoritado = true
                        },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorito"
                )
            }
        }
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