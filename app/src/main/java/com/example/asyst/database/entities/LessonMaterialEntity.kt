package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_material_table")
data class LessonMaterialEntity (
    @PrimaryKey
    @ColumnInfo(name = "lesson_material_id")
    val lessonMaterialID: Long,

    val title: String,

    val link: String
)