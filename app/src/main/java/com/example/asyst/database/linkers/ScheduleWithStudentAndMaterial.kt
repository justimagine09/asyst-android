package com.example.asyst.database.linkers

import androidx.room.Embedded
import androidx.room.Relation
import com.example.asyst.database.entities.ScheduleEntity
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.database.entities.StudentLessonMaterial

data class ScheduleWithStudentAndMaterial(
    @Embedded
    val schedule: ScheduleEntity? = null,

    @Relation(parentColumn = "student_id", entityColumn = "student_id")
    val student: StudentEntity,

    @Relation(parentColumn = "student_id", entityColumn = "student_id", entity = StudentLessonMaterial::class)
    val studentLessonMaterial: StudentWithLessonMaterial? = null

)