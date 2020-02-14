package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.AttendanceEntity

@Dao
interface AttendanceDao {
    @Insert
    suspend fun insert(attendanceEntity: AttendanceEntity)
}