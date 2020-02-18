package com.example.asyst.respositories

import com.example.asyst.database.daos.ScheduleDao
import com.example.asyst.database.linkers.ScheduleWithStudentAndMaterial

class ScheduleRepository(private val scheduleDao: ScheduleDao) {

    suspend fun getScheduleWithStudentAndLessonMaterial(): List<ScheduleWithStudentAndMaterial> {
        return scheduleDao.getStudentWithSchedule()
    }
}