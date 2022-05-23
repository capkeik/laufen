package com.example.laufen.maps.nav

sealed class Screen(val route: String) {
    object Activity: Screen("activity")
}
