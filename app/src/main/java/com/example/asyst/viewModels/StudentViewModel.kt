package com.example.asyst.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.asyst.database.AppDatabase
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.respositories.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(application: Application): AndroidViewModel(application) {
    private val studentRepository: StudentRepository
    private val students: MutableLiveData<List<StudentEntity>> = MutableLiveData()
    private val studentsLoaded: MutableLiveData<Boolean> = MutableLiveData(true)

    init {
        val studentDao = AppDatabase.getInstance(application).studentDao()
        studentRepository = StudentRepository(studentDao)
    }

    fun insert(studentEntity: StudentEntity) = viewModelScope.launch {
        studentRepository.addStudent(studentEntity)
    }

    fun getAll(studentEntity: StudentEntity) = viewModelScope.launch {
        studentsLoaded.postValue(false)

        val resStudents = studentRepository.getAll()
        students.postValue(resStudents)
        studentsLoaded.postValue(true)
    }
}