package com.example.laufen.maps.nav.nested

sealed class ProfileScreens(val route: String) {
    object Profile : ProfileScreens("profile")
}
