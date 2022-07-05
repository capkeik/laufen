package com.example.laufen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.laufen.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUserSignedIn()) goToLSignIn() else {
        }
    }

    private fun isUserSignedIn() = false

    private fun goToLSignIn() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
