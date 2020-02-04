package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.LessonMaterialEntity

@Dao
interface LessonMaterialDao {
    @Insert
    suspend fun insert(lessonMaterialEntity: LessonMaterialEntity)
}