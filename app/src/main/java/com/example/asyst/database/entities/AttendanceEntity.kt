package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.asyst.models.enums.EAttendanceStatus
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
data class AttendanceEntity (
    @PrimaryKey
    @ColumnInfo(name = "attendance_id")
    val attendanceID: Long? = null,

    @ColumnInfo(name = "date_schedule")
    val dateSchedule: Date,

    @ColumnInfo(name = "student_id")
    val studentID: Long? = null,

    @ColumnInfo(name = "lesson_material_id")
    val lessonMaterialID: Long? = null,

    @ColumnInfo(name = "lesson_page_from")
    val lesson_page_from: Int? = null,

    @ColumnInfo(name = "lesson_page_to")
    val lesson_page_to: Int? = null,

    val status: EAttendanceStatus
)