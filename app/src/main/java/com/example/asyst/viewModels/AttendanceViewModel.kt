package com.example.asyst.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.asyst.database.AppDatabase
import com.example.asyst.respositories.AttendanceRepository

class AttendanceViewModel(application: Application): AndroidViewModel(application) {
    private val scheduleRepository: AttendanceRepository

    init {
        val attendanceDao = AppDatabase.getInstance(application).attendanceDao()
        scheduleRepository = AttendanceRepository(attendanceDao)
    }
}