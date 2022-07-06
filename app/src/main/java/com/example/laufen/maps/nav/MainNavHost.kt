package com.example.laufen.maps.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.laufen.maps.nav.nested.ActivityScreens
import com.example.laufen.maps.nav.nested.ProfileScreens
import com.example.laufen.maps.nav.nested.ProgressScreens
import com.example.laufen.maps.presentation.*
import com.example.laufen.maps.presentation.schedule.ScheduleScreen

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
