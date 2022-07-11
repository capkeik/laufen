package com.example.laufen.nav.nested

sealed class ProfileScreens(val route: String) {
    object Profile : ProfileScreens("profile")
}
