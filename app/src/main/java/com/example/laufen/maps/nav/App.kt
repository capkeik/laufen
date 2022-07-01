package com.example.laufen.maps.nav

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.laufen.maps.nav.nested.ActivityScreens
import com.example.laufen.maps.presentation.composables.BottomNavBar
import com.example.laufen.ui.theme.LaufenTheme

@Composable
fun App() {
    LaufenTheme {
        val navController = rememberNavController()

        var showBottomBar by rememberSaveable { mutableStateOf(true) }
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        showBottomBar = when (navBackStackEntry?.destination?.route) {
            ActivityScreens.Training.route -> false
            else -> true
        }

        Scaffold(
            bottomBar = { if (showBottomBar) { BottomNavBar(navController) } }
        ) {
            MainNavHost(
                navController = navController,
                startDestination = ActivityScreens.Activity.route
            )
        }
    }
}
