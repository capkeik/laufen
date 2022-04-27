package com.example.laufen.auth

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laufen.composables.SignInPage
import com.example.laufen.ui.theme.LaufenTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.i("launch", "Login Activity")
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED)
        setContent {
            LaufenTheme {
                LoginView()
            }
        }
    }

    @Composable
    fun LoginView() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable(
                "login_page",
                content = {
                    SignInPage(navController = navController)
                })
        })
    }
}
