package com.example.loreria

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loreria.ui.screens.HomeScreen
import com.example.loreria.ui.screens.LoteriaScreen

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("loteria") {
            LoteriaScreen(navController)
        }
    }
}
