package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.asyst.models.enums.EScheduleStatus
import com.example.asyst.models.enums.EWeekDays
import org.jetbrains.annotations.NotNull

@Entity(tableName = "schedule_table")
data class ScheduleEntity(
 @PrimaryKey(autoGenerate = true)
 @ColumnInfo(name = "schedule_id")
 val scheduleID: Long,

 @NotNull
 @ColumnInfo(name = "week_day")
 val weekDay: EWeekDays? = null,

 @NotNull
 @ColumnInfo(name = "time_start")
 val timeStart: String? = null,

 @NotNull
 @ColumnInfo(name = "time_end")
 val timeEnd: String? = null,

 val status: EScheduleStatus,

 @NotNull
 @ForeignKey(entity = StudentEntity::class, parentColumns = ["student_id"], childColumns = ["student_id"])
 @ColumnInfo(name = "student_id")
 val studentID: Long? = null
)