package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "student_lesson_material_table")
data class StudentLessonMaterial (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_lesson_material_id")
    val id: Long? = null,

    @ColumnInfo(name = "current_page_from")
    val currentPageFrom: Int? = null,

    @ColumnInfo(name = "current_page_to")
    val currentPageTo: Int? = null,

    @ColumnInfo(name = "next_page_from")
    val NextPageFrom: Int? = null,

    @ColumnInfo(name = "next_page_to")
    val NexPageTo: Int? = null,

    @ForeignKey(entity = StudentEntity::class, parentColumns = ["student_id"], childColumns = ["student_id"])
    @ColumnInfo(name = "student_id")
    val studentID: Long,

    @ForeignKey(entity = LessonMaterialEntity::class, parentColumns = ["lesson_material_id"], childColumns = ["lesson_material_id"])
    @ColumnInfo(name = "lesson_material_id")
    val lessonMaterialID: Long
)