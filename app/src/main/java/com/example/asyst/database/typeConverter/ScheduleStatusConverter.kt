package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EScheduleStatus
import com.example.asyst.models.enums.EStudentStatus

class ScheduleStatusConverter {
    @TypeConverter
    fun fromStudentStatus(value: EScheduleStatus): String {
        return value.toString()
    }

    @TypeConverter
    fun studentStatusString(value: String): EScheduleStatus {
        var status: EScheduleStatus

        if (value == EScheduleStatus.ACTIVE.toString()) {
            status = EScheduleStatus.ACTIVE
       } else {
            status = EScheduleStatus.DELETED
        }

        return status as EScheduleStatus
    }
}
