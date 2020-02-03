package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromDate(date: Date): Long? {
        return date.let { date.getTime() }
    }

    @TypeConverter
    fun toDate(dateLong: Long): Date? {
        return dateLong.let { Date(it) }
    }
}