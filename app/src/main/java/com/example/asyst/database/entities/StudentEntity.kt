package com.example.asyst.database.entities

import androidx.room.*
import com.example.asyst.database.typeConverter.StudentStatusConverter
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EStudentStatus
import java.util.*


@Entity(tableName = "student_table")
data class StudentEntity(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "student_id")
  val studentID: Long? = null,

  @ColumnInfo(name = "first_name")
  val firstName: String,

  @ColumnInfo(name = "last_name")
  val lastName: String,

  @ColumnInfo(name = "nick_name")
  val nickName: String,

  val gender: EGender,

  @TypeConverters(StudentStatusConverter::class)
  val status: EStudentStatus,

  val timeStamp: Date
)