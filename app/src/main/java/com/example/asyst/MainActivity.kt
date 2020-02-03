package com.example.asyst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.asyst.database.AppDatabase
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EStudentStatus
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getInstance(this)
        val student = StudentEntity(firstName = "john", lastName = "doe", nickName = "doedoe", gender = EGender.MALE, status = EStudentStatus.REGULAR)

        CoroutineScope(Dispatchers.IO).launch {
            db.studentDao().insertStudent(student)
        }

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
