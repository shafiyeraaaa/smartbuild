package com.example.smartbuild.viewmodel

import androidx.lifecycle.ViewModel
import com.example.smartbuild.model.ScheduleItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScheduleViewModel : ViewModel() {
    private val _scheduleList = MutableStateFlow<List<ScheduleItem>>(emptyList())
    val scheduleList: StateFlow<List<ScheduleItem>> = _scheduleList

    fun addScheduleItem(item: ScheduleItem) {
        _scheduleList.value = _scheduleList.value + item
    }
}

