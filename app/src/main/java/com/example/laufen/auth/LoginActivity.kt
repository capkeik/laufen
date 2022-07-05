package com.example.laufen.auth

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.Observer
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laufen.auth.presentation.LoginViewModel
import com.example.laufen.auth.presentation.SignUpViewModel
import com.example.laufen.auth.presentation.composables.SignInPage
import com.example.laufen.auth.presentation.composables.SignUpPage
import com.example.laufen.ui.theme.LaufenTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : ComponentActivity() {
    val auth = Firebase.auth
    private val loginViewModel = LoginViewModel()
    private var signUpViewModel = SignUpViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                    SignInPage(navController = navController, loginViewModel)
                })
            composable(
                "sign_in_page",
                content = {
                    SignUpPage(navController = navController, signUpViewModel)
                })
        })
    }
}