package com.example.laufen.maps.presentation.schedule

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
import java.util.*

@Composable
fun ScheduleScreen() {
    val viewModel: ScheduleViewModel = viewModel()
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

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
        Button(
            onClick = { timePickerDialog.show() }
        ) {
            Text(text = "Plan Training", color = Color.White)
        }
        Spacer(modifier = Modifier.size(100.dp))

        Text(text = "Selected Time: ${time.value}", fontSize = 30.sp)
    }
}
