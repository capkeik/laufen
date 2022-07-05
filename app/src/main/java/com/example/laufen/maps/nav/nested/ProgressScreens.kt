package com.example.laufen.maps.nav.nested

sealed class ProgressScreens(val route: String) {
    object Progress : ProgressScreens("progress")
    object Schedule : ProgressScreens("schedule")
}
