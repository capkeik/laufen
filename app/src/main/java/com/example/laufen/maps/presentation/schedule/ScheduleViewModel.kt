package com.example.laufen.maps.presentation.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ScheduleViewState(
    val millis: Long = 0
)

class ScheduleViewModel : ViewModel() {
    private val _viewState: MutableLiveData<ScheduleViewState> = MutableLiveData(ScheduleViewState())
    val viewState: LiveData<ScheduleViewState> get() = _viewState

    fun putMillis(millis: Long) {
        _viewState.postValue(
            viewState.value?.copy(
            millis = millis
            )
        )
    }
}
