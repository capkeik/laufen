package com.example.laufen.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.laufen.nav.nested.ActivityScreens
import com.example.laufen.nav.nested.ProfileScreens
import com.example.laufen.nav.nested.ProgressScreens
import com.example.laufen.maps.presentation.*
import com.example.laufen.ui.schedule.ScheduleScreen
import com.example.laufen.ui.screens.TrainingScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ActivityScreens.Activity.route) {
            ActivityScreen(navController)
        }
        composable(ActivityScreens.Training.route) {
            TrainingScreen(navController)
        }
        composable(ProgressScreens.Progress.route) {
            ProgressScreen(navController)
        }
        composable(ProgressScreens.Schedule.route) {
            ScheduleScreen()
        }
        composable(ProfileScreens.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
