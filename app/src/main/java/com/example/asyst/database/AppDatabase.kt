package com.example.asyst.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.asyst.database.daos.*
import com.example.asyst.database.entities.*
import com.example.asyst.database.typeConverter.*
import com.example.asyst.models.enums.EAttendanceStatus

@Database(
    entities = [StudentEntity::class, LessonMaterialEntity::class, AttendanceEntity::class, StudentLessonMaterial::class, ScheduleEntity::class],
    version = 19,
    exportSchema = false)
@TypeConverters(DateConverter::class, DateConverter::class, GenderConverter::class,StudentStatusConverter::class, ScheduleStatusConverter::class, WeekDaysConverter::class, LessonMaterialStatusConverter::class, AttendanceStatusConverter::class, StudentLessonMaterialStatus::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun lessonMaterialDao(): LessonMaterialDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun studentLessonMaterialDao(): StudentLessonMaterialDao
    abstract fun scheduleDao(): ScheduleDao
    abstract fun studentWithScheduleDoa(): StudentWithScheduleDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = instance

            if(tempInstance != null) return  tempInstance

            synchronized(this) {
                val instance_ = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "attendance_system"
                ).fallbackToDestructiveMigration().build()

                instance = instance_

                return instance as AppDatabase
            }
        }
    }
}