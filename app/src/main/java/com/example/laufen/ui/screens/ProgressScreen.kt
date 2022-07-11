package com.example.laufen.maps.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laufen.nav.nested.ProgressScreens

@Composable
fun ProgressScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { navController.navigate(ProgressScreens.Schedule.route) }
        ) {
            Text(text = "Open Time Picker", color = Color.White)
        }
        Spacer(modifier = Modifier.size(100.dp))

        Text("Progress Screen")
    }
}
