package com.example.laufen.ui.schedule

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laufen.data.schedule.entity.ScheduleEntity
import java.util.*

@Composable
fun ScheduleScreen() {

    val viewModel: ScheduleViewModel = viewModel()
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val viewState: State<ScheduleViewState> = viewModel.viewState.observeAsState(ScheduleViewState())
    val timePickerDialog = TimePickerDialog(
        context,
        { _, hour: Int, mMinute: Int ->
            viewModel.addSchedule(hour, mMinute, listOf(0), context)
        }, hourOfDay, minute, false
    )

    LaunchedEffect("initScheduleRepo") { viewModel.initRepo(context) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { timePickerDialog.show() }
        ) {
            Text(text = "Plan Training", color = Color.White)
        }
        LazyColumn {
            items(viewState.value.schedule) { item: ScheduleEntity ->
                ScheduleItem(item = item)
            }
        }
        Spacer(modifier = Modifier.size(100.dp))
    }
}

@Composable
fun ScheduleItem(item: ScheduleEntity) {
    Row(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("${item.hour}:${item.minute}")
        Text(item.dayOfWeek.toString())
    }
}
