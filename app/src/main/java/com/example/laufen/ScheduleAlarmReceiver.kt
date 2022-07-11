package com.example.laufen

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.laufen.data.schedule.ScheduleRepositoryPrefs
import com.example.laufen.data.schedule.Scheduler
import com.example.laufen.data.schedule.entity.ScheduleEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


const val currentExtra = "currentExtra"

class ScheduleAlarmReceiver : BroadcastReceiver() {
    private val gson = Gson()
    override fun onReceive(context: Context, intent: Intent) {
        val repository = ScheduleRepositoryPrefs(context)
        val parseType = object : TypeToken<ScheduleEntity>() {}.type
        val current = gson.fromJson<ScheduleEntity>(intent.getStringExtra(currentExtra), parseType)
        Scheduler.setSingleAlarm(context, repository.getNextAlarm().millis)
        showNotification(context, "БЕГИ, СУКА, БЕГИИИИИ!!!!!!!", "пора на треню")
    }
}

private fun showNotification(context: Context, title: String, desc: String) {
    val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val channelId = "training-alarm-channel"
    val channelName = "training-alarm"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        manager.createNotificationChannel(channel)
    }

    val builder = NotificationCompat.Builder(context, channelId)
        .setContentTitle(title)
        .setContentText(desc)
        .setSmallIcon(R.drawable.ic_activity)

    manager.notify(1, builder.build())

}
