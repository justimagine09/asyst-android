package com.example.asyst.respositories

import com.example.asyst.database.daos.StudentDao
import com.example.asyst.database.entities.StudentEntity

class StudentRepository(private val studentDao: StudentDao) {
    
    suspend fun addStudent(studentEntity: StudentEntity) {
        return studentDao.insertStudent(studentEntity)
    }
}