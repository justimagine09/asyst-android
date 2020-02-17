package com.example.asyst.views.pages


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asyst.R
import com.example.asyst.adapters.ScheduleWithStudentAndMaterialAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    lateinit var root: View
    lateinit var scheduleWithStudentAndMaterialRecyclerView: RecyclerView
    lateinit var scheduleWithStudentAndMaterialAdapter: ScheduleWithStudentAndMaterialAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        initializeHeader()
        initializeScheduleWithStudentAndMaterialAdapter()

        return root
    }

    private fun initializeScheduleWithStudentAndMaterialAdapter() {

        scheduleWithStudentAndMaterialRecyclerView = root.schedule_with_student_and_material_recycler_view.adapter as RecyclerView

        scheduleWithStudentAndMaterialRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
        }

        if(scheduleWithStudentAndMaterialAdapter == null) {
            scheduleWithStudentAndMaterialAdapter = ScheduleWithStudentAndMaterialAdapter()
            scheduleWithStudentAndMaterialRecyclerView.adapter = scheduleWithStudentAndMaterialAdapter
        }

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
