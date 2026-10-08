package com.example.navegacaofluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween(1000)
                            )
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween(1000)
                            )
                        }
                    ){
                        composable (route = "login",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(1000)
                                ) + fadeOut(animationSpec = tween(1000))
                            }) { LoginScreen(modifier = Modifier.padding(innerPadding),navController) }

                        composable (route = "menu") { MenuScreen(modifier = Modifier.padding(innerPadding),navController) }

                        composable (route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument("numeroPedido"){
                                    defaultValue = "Sem pedidos"
                                }
                            )) {

                            val numeroPedido = it.arguments?.getString("numeroPedido")

                            PedidosScreen(modifier = Modifier.padding(innerPadding),
                                navController, numeroPedido = numeroPedido!!)
                            }

                        composable (route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome"){
                                type = NavType.StringType
                            }, navArgument("idade"){
                                    type = NavType.IntType
                                }
                            )) {
                            val nome = it.arguments?.getString("nome")
                            val idadee = it.arguments?.getInt("idade")

                            PerfilScreen(modifier = Modifier.padding(innerPadding),
                                navController, nome = nome!!,idadee!!)}
                            // !! = quer dizer "Confia que vem" kkk em outras palavras tamo dizendo que vai vir kk
                    }
                }
            }
        }
    }
}