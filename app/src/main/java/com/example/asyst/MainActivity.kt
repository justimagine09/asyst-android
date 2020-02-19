package com.example.asyst
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
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
                    findNavController(R.id.nav_host_fragment).navigate(R.id.home, null, NavOptions.Builder().setEnterAnim(R.anim.slide_right_to_left).setExitAnim(R.anim.slide_left_to_right).build())
                R.id.bottom_menu_students ->
                    findNavController(R.id.nav_host_fragment).navigate(R.id.addStudentFragment, null, NavOptions.Builder().setEnterAnim(R.anim.slide_right_to_left).setExitAnim(R.anim.slide_left_to_right).build())
            }

            true
        }
    }
}
