package com.example.asyst.viewModels

import android.app.Application
import com.example.asyst.database.AppDatabase
import com.example.asyst.respositories.ScheduleRepository

class ScheduleViewModel(application: Application) {
    private val scheduleRepository: ScheduleRepository

    init {
        val scheduleDao = AppDatabase.getInstance(application).scheduleDao()
        scheduleRepository = ScheduleRepository(scheduleDao)
    }
}