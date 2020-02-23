package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.asyst.database.entities.StudentEntity

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdate(studentEnity: StudentEntity)

    @Query("select * from student_table where student_id = :studentID")
    suspend fun getStudentByID(studentID: Long): StudentEntity

    @Query("SELECT * FROM student_table")
    suspend fun getAll(): List<StudentEntity>
}