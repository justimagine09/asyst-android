package com.example.asyst.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.asyst.database.AppDatabase
import com.example.asyst.respositories.ScheduleRepository

class ScheduleViewModel(application: Application): AndroidViewModel(application) {
    private val scheduleRepository: ScheduleRepository

    init {
        val scheduleDao = AppDatabase.getInstance(application).scheduleDao()
        scheduleRepository = ScheduleRepository(scheduleDao)
    }
}