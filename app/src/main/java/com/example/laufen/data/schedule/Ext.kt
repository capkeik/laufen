package com.example.laufen.data.schedule

import com.example.laufen.data.schedule.entity.ScheduleEntity
import java.util.Calendar

fun ScheduleEntity.initMillis() {
    val calendar = Calendar.getInstance()
    with(calendar) {
        set(Calendar.DAY_OF_WEEK, this@initMillis.dayOfWeek)
        set(Calendar.HOUR_OF_DAY, this@initMillis.hour)
        set(Calendar.MINUTE, this@initMillis.minute)
    }
    this.millis = calendar.timeInMillis
}

fun ScheduleEntity.addWeek() {
    val calendar = Calendar.getInstance()
    with(calendar) {
        set(Calendar.DAY_OF_WEEK, this@addWeek.dayOfWeek)
        set(Calendar.HOUR_OF_DAY, this@addWeek.hour)
        set(Calendar.MINUTE, this@addWeek.minute)
        add(Calendar.WEEK_OF_YEAR, 1)
    }
    this.millis = calendar.timeInMillis
}
