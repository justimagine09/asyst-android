package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.StudentLessonMaterial

@Dao
interface StudentLessonMaterialDao {
    @Insert
    suspend fun insert(studentLessonMaterialEntity: StudentLessonMaterial)
}