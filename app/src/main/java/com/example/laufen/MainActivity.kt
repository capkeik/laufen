package com.example.laufen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.laufen.auth.LoginActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUserSignedIn()) goToLSignIn()
    }

    private fun isUserSignedIn() = false

    private fun goToLSignIn() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
