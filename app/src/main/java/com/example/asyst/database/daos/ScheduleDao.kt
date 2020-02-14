package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.asyst.database.entities.ScheduleEntity
import com.example.asyst.database.linkers.ScheduleWithStudent

@Dao
interface ScheduleDao {
    @Insert
    suspend fun insert(ScheduleEntity: ScheduleEntity)
}