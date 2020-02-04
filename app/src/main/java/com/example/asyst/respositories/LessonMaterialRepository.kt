package com.example.asyst.respositories
import com.example.asyst.database.daos.LessonMaterialDao
import com.example.asyst.database.entities.LessonMaterialEntity

class LessonMaterialRepository(private val lessonMaterialDao: LessonMaterialDao) {
    
    suspend fun addBook(lessonMaterialEntity: LessonMaterialEntity) {
        return lessonMaterialDao.insert(lessonMaterialEntity)
    }
}