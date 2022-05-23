package com.example.laufen.auth.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.laufen.R
import com.example.laufen.auth.domain.LoadingState
import com.example.laufen.auth.presentation.LoginViewModel
import com.example.laufen.ui.theme.whiteBackground

@Composable
fun SignInPage(
    navController: NavController,
    viewModel: LoginViewModel
) {
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    val state by viewModel.loadingState.collectAsState()

    val passwordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(30.dp))
                .background(whiteBackground)
                .padding(10.dp)
        ) {
            OutlinedTextField(
                value = emailValue,
                onValueChange = { emailValue = it },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            OutlinedTextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {

                        Icon(
                            painter = if (passwordVisibility.value) painterResource(
                                id = R.drawable.ic_visibility_off_24)
                            else painterResource(
                                id = R.drawable.ic_visibility_24),
                            contentDescription = "password visibility = ${passwordVisibility.value}"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            TextButton("Sign In") {
                viewModel.signInWithEmailAndPassword(emailValue, passwordValue)
            }

            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Create An Account",
                modifier = Modifier.clickable(onClick = {
                    navController.navigate("register_page"){
                        launchSingleTop = true
                    }
                })
            )
            Spacer(modifier = Modifier.padding(20.dp))

            when(state.status) {
                LoadingState.Status.SUCCESS -> {
                    Text(text = "Success")
                }
                LoadingState.Status.FAILED -> {
                    Text(text = state.msg ?: "Error")
                }
                else -> {}
            }
        }
    }
}

@Composable
fun TextButton(
    text: String = "",
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp)
    ) {
        Text(text = text, fontSize = 20.sp)
    }
    }

