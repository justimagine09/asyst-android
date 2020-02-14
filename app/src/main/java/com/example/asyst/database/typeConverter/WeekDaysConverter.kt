package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EWeekDays

class WeekDaysConverter {
    @TypeConverter
    fun fromEGender(value: EWeekDays?): Int? {
        return value?.let { it.ordinal }
    }

    @TypeConverter
    fun weekDaysInt(value: Int?): EWeekDays? {
      return when (value) {
            EWeekDays.MONDAY.ordinal -> EWeekDays.MONDAY
            EWeekDays.TUESDAY.ordinal -> EWeekDays.TUESDAY
            EWeekDays.WEDNESDAY.ordinal -> EWeekDays.WEDNESDAY
            EWeekDays.THURSDAY.ordinal -> EWeekDays.THURSDAY
            EWeekDays.FRIDAY.ordinal -> EWeekDays.FRIDAY
            EWeekDays.SATURDAY.ordinal -> EWeekDays.SATURDAY
            EWeekDays.SUNDAY.ordinal -> EWeekDays.SUNDAY
            else -> null
        }
    }
}
