package com.example.navegacaofluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacaofluxotelas.screen.LoginScreen
import com.example.navegacaofluxotelas.screen.MenuScreen
import com.example.navegacaofluxotelas.screen.PedidosScreen
import com.example.navegacaofluxotelas.screen.PerfilScreen

import com.example.navegacaofluxotelas.ui.theme.NavegacaoFluxoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoFluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable (route = "login") { LoginScreen() }

                        composable (route = "menu") { MenuScreen() }

                        composable (route = "pedidos") { PedidosScreen() }
                        // ver a diferenca se deixar aqui
                        composable (route = "perfil") { PerfilScreen() }
                    }

                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}