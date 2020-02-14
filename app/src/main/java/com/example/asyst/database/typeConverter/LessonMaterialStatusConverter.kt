package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.ELessonMaterialStatus

class LessonMaterialStatusConverter {
    @TypeConverter
    fun fromStudentStatus(value: ELessonMaterialStatus?): String? {
        return value?.let { it.toString() }
    }

    @TypeConverter
    fun studentStatusString(value: String?): ELessonMaterialStatus? {
        lateinit var status: ELessonMaterialStatus

        when(value) {
            ELessonMaterialStatus.ACTIVE.toString() -> status = ELessonMaterialStatus.ACTIVE
            ELessonMaterialStatus.DELETED.toString() -> status = ELessonMaterialStatus.DELETED
       }

        return status
    }
}
