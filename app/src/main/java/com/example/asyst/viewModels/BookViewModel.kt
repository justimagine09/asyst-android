package com.example.asyst.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.asyst.database.AppDatabase
import com.example.asyst.respositories.LessonMaterialRepository

class LessonMaterialViewModel(application: Application): AndroidViewModel(application) {
    private val bookRepository: LessonMaterialRepository

    init {
        val lessonMaterialDao = AppDatabase.getInstance(application).lessonMaterialDao()
        bookRepository = LessonMaterialRepository(lessonMaterialDao)
    }
}