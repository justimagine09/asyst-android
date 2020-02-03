package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EStudentStatus

class StudentStatusConverter {
    @TypeConverter
    fun fromStudentStatus(value: EStudentStatus?): String? {
        return value?.let { it.toString() }
    }

    @TypeConverter
    fun studentStatusString(value: String?): EStudentStatus? {
        lateinit var status: EStudentStatus

        when(value) {
            EStudentStatus.REGULAR.toString() -> status = EStudentStatus.REGULAR
            EStudentStatus.TRIAL.toString() -> status = EStudentStatus.TRIAL
            EStudentStatus.ON_HOLD.toString() -> status = EStudentStatus.ON_HOLD
            EStudentStatus.DELETED.toString() -> status = EStudentStatus.TRIAL
       }

        return status
    }
}
