package com.example.asyst.database.typeConverter

import androidx.room.TypeConverter
import com.example.asyst.models.enums.EGender

class GenderConverter {
    @TypeConverter
    fun fromEGender(value: EGender?): String? {
        return value?.let { it.toString() }
    }

    @TypeConverter
    fun genderString(value: String?): EGender? {
        return if(value == EGender.MALE.toString()) {
            EGender.MALE
        } else {
            EGender.FEMALE
        }
    }
}
