package com.example.asyst.viewModels

import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.asyst.database.AppDatabase
import com.example.asyst.database.linkers.ScheduleWithStudentAndMaterial
import com.example.asyst.respositories.ScheduleRepository
import kotlinx.coroutines.launch

class ScheduleViewModel(application: Application): AndroidViewModel(application) {
    private val scheduleRepository: ScheduleRepository

    private var scheduleWithStudentAndMaterial = MutableLiveData<List<ScheduleWithStudentAndMaterial>>()
    private val scheduleWithStudentAndMaterialLoaded =  MutableLiveData<Boolean>(true)

    init {
        val scheduleDao = AppDatabase.getInstance(application).scheduleDao()
        scheduleRepository = ScheduleRepository(scheduleDao)
    }

    fun fetchScheduleWithStudentAndMaterial() = viewModelScope.launch {
        scheduleWithStudentAndMaterialLoaded.postValue(false)

        try {
            val schedWSAM: List<ScheduleWithStudentAndMaterial> = scheduleRepository.getScheduleWithStudentAndLessonMaterial()
            scheduleWithStudentAndMaterial.postValue(schedWSAM)
        } catch (e: SQLiteException) {
            Log.d("SQLiteException", e.toString())
        }
    }

    fun scheduleWithStudentAndMaterialLoaded():LiveData<Boolean> = scheduleWithStudentAndMaterialLoaded

    fun getScheduleWithStudentAndMaterial(): LiveData<List<ScheduleWithStudentAndMaterial>> = scheduleWithStudentAndMaterial
}