package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.asyst.models.enums.EScheduleStatus
import com.example.asyst.models.enums.EStudentStatus
import java.util.*

@Entity(
    tableName = "attendance_table",
    foreignKeys = [
        ForeignKey(entity = StudentEntity::class, parentColumns = ["student_id"], childColumns = ["student_id"]),
        ForeignKey(entity = LessonMaterialEntity::class, parentColumns = ["lesson_material_id"], childColumns = ["lesson_material_id"])
    ]
)
data class AttendanceEnity (
    @PrimaryKey
    @ColumnInfo(name = "attendance_id")
    val attendaceID: Long,

    @ColumnInfo(name = "date_schedule")
    val dateSchedule: Date,

    val status: EScheduleStatus,

    val studentStatus: EStudentStatus,

    @ColumnInfo(name = "student_id")
    val studentID: Long,

    @ColumnInfo(name = "lesson_material_id")
    val lessonMaterialID: Long? = null
)