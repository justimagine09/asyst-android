package com.example.asyst.database.typeConverter

import android.util.Log
import androidx.room.TypeConverter
import com.example.asyst.models.enums.EScheduleStatus

class ScheduleStatusConverter {
    @TypeConverter
    fun fromScheduleStatus(value: EScheduleStatus): String {
        return value.toString()
    }

    @TypeConverter
    fun scheduleStatusString(value: String): EScheduleStatus {
        Log.d("DD", "${value} == ${EScheduleStatus.ACTIVE.toString()}")

        return if (value == EScheduleStatus.ACTIVE.toString()) {
            EScheduleStatus.ACTIVE
       } else {
            EScheduleStatus.ACTIVE
        }
    }
}
