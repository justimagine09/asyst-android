package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EScheduleStatus
import com.example.asyst.models.enums.EStudentStatus

class ScheduleStatusConverter {
    @TypeConverter
    fun fromStudentStatus(value: EScheduleStatus?): String? {
        return value?.let { it.toString() }
    }

    @TypeConverter
    fun studentStatusString(value: String?): EScheduleStatus? {
        lateinit var status: EScheduleStatus

        when(value) {
            EScheduleStatus.PENDING.toString() -> status = EScheduleStatus.PENDING
            EScheduleStatus.COMPLETED.toString() -> status = EScheduleStatus.COMPLETED
            EScheduleStatus.CANCELLED.toString() -> status = EScheduleStatus.CANCELLED
       }

        return status
    }
}
