package com.example.asyst.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.asyst.database.daos.ScheduleDao
import com.example.asyst.database.daos.StudentDao
import com.example.asyst.database.entities.BookEntity
import com.example.asyst.database.entities.ScheduleEntity
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.database.typeConverter.DateConverter
import com.example.asyst.database.typeConverter.GenderConverter
import com.example.asyst.database.typeConverter.ScheduleStatusConverter
import com.example.asyst.database.typeConverter.StudentStatusConverter

@Database(
    entities = [StudentEntity::class, BookEntity::class, ScheduleEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters(DateConverter::class, DateConverter::class, GenderConverter::class,StudentStatusConverter::class, ScheduleStatusConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun scheduleDao(): ScheduleDao

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