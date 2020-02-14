package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EStudentStatus

class StudentStatusConverter {
    @TypeConverter
    fun fromStudentStatus(value: EStudentStatus): String {
        return value.toString()
    }

    @TypeConverter
    fun studentStatusString(value: String): EStudentStatus {
        return if(value === EStudentStatus.REGULAR.toString()) {
            EStudentStatus.REGULAR
       } else if(value === EStudentStatus.TRIAL.toString()) {
            EStudentStatus.TRIAL
        } else if(value === EStudentStatus.ON_HOLD.toString()) {
            EStudentStatus.ON_HOLD
        } else {
            EStudentStatus.TRIAL
        }
    }
}
