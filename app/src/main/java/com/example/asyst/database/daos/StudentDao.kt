package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.StudentEntity

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(studentEnity: StudentEntity)
}