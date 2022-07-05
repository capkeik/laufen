package com.example.laufen.maps.nav.nested

sealed class ActivityScreens(val route: String) {
    object Activity: ActivityScreens("activity")
    object Training: ActivityScreens("training")
}
