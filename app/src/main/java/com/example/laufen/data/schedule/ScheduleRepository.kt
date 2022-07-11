package com.example.laufen.data.schedule

import com.example.laufen.data.schedule.entity.ScheduleEntity

interface ScheduleRepository {
    fun getNextAlarm(): ScheduleEntity
    fun addAlarms(plans: List<ScheduleEntity>)
    fun removeAlarm(planToRemove: ScheduleEntity)
    fun getAlarms(): List<ScheduleEntity>
}
