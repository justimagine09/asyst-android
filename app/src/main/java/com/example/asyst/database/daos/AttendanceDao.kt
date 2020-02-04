package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.AttendanceEnity

@Dao
interface AttendanceDao {
    @Insert
    suspend fun insert(attendanceEnity: AttendanceEnity)
}