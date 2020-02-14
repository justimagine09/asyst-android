package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EStudentLessonMaterialStatus

class StudentLessonMaterialStatus {
    @TypeConverter
    fun fromStudentStatus(value: EStudentLessonMaterialStatus?): String? {
        return value?.let { it.toString() }
    }

    @TypeConverter
    fun studentStatusString(value: String?): EStudentLessonMaterialStatus? {
        lateinit var status: EStudentLessonMaterialStatus

        when(value) {
            EStudentLessonMaterialStatus.ACTIVE.toString() -> status = EStudentLessonMaterialStatus.ACTIVE
            EStudentLessonMaterialStatus.DELETED.toString() -> status = EStudentLessonMaterialStatus.DELETED
       }

        return status
    }
}
