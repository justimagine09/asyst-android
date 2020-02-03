package com.example.asyst.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.asyst.database.AppDatabase
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.respositories.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {
    private val studentRepository: StudentRepository

    init {
        val studentDao = AppDatabase.getInstance(application).studentDao()
        studentRepository = StudentRepository(studentDao)
    }

    fun insert(studentEntity: StudentEntity) = viewModelScope.launch {
        studentRepository.addStudent(studentEntity)
    }
}