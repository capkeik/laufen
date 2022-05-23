package com.example.laufen.maps.nav

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laufen.maps.presentation.ActivityScreen
import com.example.laufen.ui.theme.LaufenTheme

@Composable
fun App() {
    LaufenTheme() {
        Scaffold() {
            val navController = rememberNavController()
            NavHost(
                navController,
                Screen.Activity.route
            ) {
                composable(Screen.Activity.route) {
                    ActivityScreen(navController)
                }
            }
        }
    }
}