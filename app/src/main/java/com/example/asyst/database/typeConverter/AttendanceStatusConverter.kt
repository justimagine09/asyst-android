package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EAttendanceStatus

class AttendanceStatusConverter {
    @TypeConverter
    fun toString(value: EAttendanceStatus?): String? {
        return value?.let { it.toString() }
    }

    @TypeConverter
    fun toEnum(value: String?): EAttendanceStatus? {
        lateinit var status: EAttendanceStatus

        when(value) {
            EAttendanceStatus.PRESENT.toString() -> status = EAttendanceStatus.PRESENT
            EAttendanceStatus.ABSENT.toString() -> status =EAttendanceStatus.ABSENT
            EAttendanceStatus.CANCELLED.toString() -> status =EAttendanceStatus.CANCELLED
       }

        return status
    }
}
