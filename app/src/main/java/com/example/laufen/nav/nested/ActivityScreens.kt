package com.example.laufen.nav.nested

sealed class ActivityScreens(val route: String) {
    object Activity: ActivityScreens("activity")
    object Training: ActivityScreens("training")
}
