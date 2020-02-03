package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.asyst.models.enums.EScheduleStatus
import com.example.asyst.models.enums.EStudentStatus
import java.util.*

@Entity(
    tableName = "schedule_table",
    foreignKeys = [
        ForeignKey(entity = StudentEntity::class, parentColumns = ["student_id"], childColumns = ["student_id"]),
        ForeignKey(entity = BookEntity::class, parentColumns = ["book_id"], childColumns = ["book_id"])
    ]
)
data class ScheduleEntity (
    @PrimaryKey
    @ColumnInfo(name = "schedule_id")
    val scheduleID: Long,

    @ColumnInfo(name = "date_schedule")
    val dateSchedule: Date,

    val status: EScheduleStatus,

    val studentStatus: EStudentStatus,

    @ColumnInfo(name = "student_id")
    val studentID: Long,

    @ColumnInfo(name = "book_id")
    val bookID: Long
)