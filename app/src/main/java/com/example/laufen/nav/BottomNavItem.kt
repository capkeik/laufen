package com.example.laufen.nav

import com.example.laufen.R

sealed class BottomNavItem(val title: String, var icon:Int, var route:String,) {
    object Activity: BottomNavItem(
        "Activity",
        R.drawable.ic_activity,
        "activity")
    object Progress: BottomNavItem(
        "Progress",
        R.drawable.ic_progress,
        "progress")
    object Profile: BottomNavItem(
        "Profile",
        R.drawable.ic_profile,
        "profile")
}
