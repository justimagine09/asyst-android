package com.example.asyst.database.linkers

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.asyst.database.entities.LessonMaterialEntity
import com.example.asyst.database.entities.StudentLessonMaterial

@Entity
data class StudentWithLessonMaterial(
    @Embedded
    val studentLessonMaterial: StudentLessonMaterial,

    @Relation(parentColumn = "lesson_material_id", entityColumn = "lesson_material_id", entity = LessonMaterialEntity::class)
    val lessonMaterial: LessonMaterialEntity? = null
)