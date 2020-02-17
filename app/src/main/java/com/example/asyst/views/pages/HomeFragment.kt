package com.example.asyst.views.pages


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.asyst.R
import com.example.asyst.database.linkers.ScheduleWithStudent
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        initializeHeader()

        return root
    }

    private fun initializeHeader() {
        val calendar = Calendar.getInstance().time
        val df: SimpleDateFormat = SimpleDateFormat("yyyy-MMMM-dd-EEEE")
        val formattedDate: List<String> = df.format(calendar).split("-")

        root.header_day.text = formattedDate[3]
        root.header_date.text = formattedDate[2]
        root.header_month.text = formattedDate[1]
    }


}
