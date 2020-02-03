package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.ScheduleEntity

@Dao
interface ScheduleDao {
    @Insert
    suspend fun insert(scheduleEntity: ScheduleEntity)
}