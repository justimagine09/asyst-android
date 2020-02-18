package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.asyst.database.entities.ScheduleEntity
import com.example.asyst.database.linkers.ScheduleWithStudentAndMaterial

@Dao
interface ScheduleDao {
    @Insert
    suspend fun insert(ScheduleEntity: ScheduleEntity)

    @Query("""
       SELECT sched.* FROM schedule_table as sched
       INNER JOIN student_table as Student
       ON sched.student_id = Student.student_id
       LEFT JOIN student_lesson_material_table as stud_les
       ON Student.student_id = stud_les.student_id
       LEFT JOIN lesson_material_table as les_mat
       ON stud_les.lesson_material_id =  les_mat.lesson_material_id
    """)
    suspend fun getStudentWithSchedule(): List<ScheduleWithStudentAndMaterial>
}