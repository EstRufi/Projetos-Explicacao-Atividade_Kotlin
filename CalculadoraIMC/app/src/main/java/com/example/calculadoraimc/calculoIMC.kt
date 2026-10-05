package com.example.calculadoraimc

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

open class CalculandoIMC(altura: String, peso: String) {
    var altura = altura.toDouble()

    var peso = peso.toDouble()

    fun calculando(): Double{
        // poderia ter colocado direto na altura colcoando na frente .toDouble
        var alturaConvertida = altura / 100
        var calculo = peso/ (alturaConvertida*alturaConvertida)

        var result = String.format("%.2f",calculo)
        return calculo
    }


}

