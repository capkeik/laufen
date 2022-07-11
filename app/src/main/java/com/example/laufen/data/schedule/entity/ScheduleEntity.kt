package com.example.laufen.data.schedule.entity

data class ScheduleEntity(
    val hour: Int,
    val minute: Int,
    val dayOfWeek: Int,
    var millis: Long = 0
)
