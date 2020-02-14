package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.asyst.models.enums.ELessonMaterialStatus

@Entity(tableName = "lesson_material_table", indices = [Index(value=["title"], unique = true)])
data class LessonMaterialEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "lesson_material_id")
    val lessonMaterialID: Long? = null,

    val title: String,

    val link: String,

    val status: ELessonMaterialStatus
)