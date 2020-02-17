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
