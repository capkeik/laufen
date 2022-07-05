package com.example.laufen.maps.presentation

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laufen.maps.presentation.schedule.ScheduleViewModel
import com.example.laufen.maps.presentation.schedule.ScheduleViewState
import java.util.*

@Composable
fun ScheduleScreen() {
    val viewModel: ScheduleViewModel = viewModel()
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    // Value for storing time as a string
    val time: State<ScheduleViewState> = viewModel.viewState.observeAsState(ScheduleViewState(0))
    val timePickerDialog = TimePickerDialog(
        context,
        { _, hour: Int, mMinute: Int ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, mMinute)
            viewModel.putMillis(calendar.timeInMillis)
        }, hourOfDay, minute, false
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // On button click, TimePicker is
        // displayed, user can select a time
        Button(
            onClick = { timePickerDialog.show() }
        ) {
            Text(text = "Open Time Picker", color = Color.White)
        }

        // Add a spacer of 100dp
        Spacer(modifier = Modifier.size(100.dp))

        // Display selected time
        Text(text = "Selected Time: ${time.value}", fontSize = 30.sp)
    }
}
