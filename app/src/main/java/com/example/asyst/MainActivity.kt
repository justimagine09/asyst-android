package com.example.asyst

import android.database.sqlite.SQLiteException
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.asyst.database.AppDatabase
import com.example.asyst.database.entities.AttendanceEntity
import com.example.asyst.database.entities.LessonMaterialEntity
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.database.entities.StudentLessonMaterial
import com.example.asyst.database.linkers.ScheduleWithStudent
import com.example.asyst.models.enums.*
import com.example.asyst.viewModels.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getInstance(this)
//        val cal = Calendar.getInstance()
//        val student = StudentEntity(firstName = "flore", lastName = "anne", nickName = "anneanne", gender = EGender.MALE, status = EStudentStatus.REGULAR, timeStamp = Date() )
//        val lessonMaterial = LessonMaterialEntity(title = "aralin panlipunan ii", link = "https://articles.flatx.com.ph", status = ELessonMaterialStatus.ACTIVE)
//        val attendance = AttendanceEntity(studentID = 1, status = EAttendanceStatus.ABSENT, lessonMaterialID = 1, dateSchedule = Date())
//        val studentLessonMaterial = StudentLessonMaterial(studentID = 2, lessonMaterialID = 1, currentPageFrom = 1, currentPageTo = 2)

        CoroutineScope(Dispatchers.IO).launch {
//            db.studentDao().insertUpdate(student)
//            db.studentLessonMaterialDao().insert(studentLessonMaterial)
//            try {
//                db.lessonMaterialDao().insert(lessonMaterial)
//            } catch (e: SQLiteException) {
//               Log.d("ERRRRRRRRROR", e.toString())
//            }
//           Log.d("x", db.studentWithScheduleDoa().getStudentWithSchedule().toString())
        }

        val model: StudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        
        initializeNavigation()
    }

    //navigation
    fun initializeNavigation() {
        navigation_menu.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_menu_home ->
                    findNavController(R.id.nav_host_fragment).navigate(R.id.home, null, NavOptions.Builder().setEnterAnim(R.anim.slide_left_to_right).setExitAnim(R.anim.slide_center_to_right).build())
            }

            true
        }
    }
}
