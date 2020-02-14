package com.example.asyst.database.linkers

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.asyst.database.entities.StudentLessonMaterial
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EStudentStatus
import com.example.asyst.models.enums.EWeekDays
import java.util.*

@Entity
data class Student(
  @ColumnInfo(name = "student_student_id")
  val studentID: Int? = null,

  @ColumnInfo(name = "student_first_name")
  val firstName: String? = null,

  @ColumnInfo(name = "student_last_name")
  val lastName: String? = null,

  @ColumnInfo(name = "student_nick_name")
  val nickName: String? = null,

  @ColumnInfo(name = "student_gender")
  val gender: EGender? = null,

  @ColumnInfo(name = "student_status")
  val status: EStudentStatus? = null,

  @ColumnInfo(name = "student_timeStamp")
  val timeStamp: Date? = null

)