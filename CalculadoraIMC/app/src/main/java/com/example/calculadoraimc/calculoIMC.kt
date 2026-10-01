package com.example.calculadoraimc

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

open class CalculandoIMC(altura: String, peso: String) {
    var altura = altura.toDouble()

    var peso = peso.toDouble()

    fun calculando(): Double{

        var calculo = peso/ (altura*altura)

        var result = String.format("%.2f",calculo)
        return calculo
    }


}

