package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EStudentStatus
import com.example.asyst.models.enums.EWeekDays
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

  val status: EStudentStatus,

  val timeStamp: Date
)