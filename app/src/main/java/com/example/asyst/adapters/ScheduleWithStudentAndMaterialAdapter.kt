package com.example.asyst.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asyst.R
import com.example.asyst.database.linkers.ScheduleWithStudentAndMaterial
import kotlinx.android.synthetic.main.item_schedule_with_student_and_materials.view.*

class ScheduleWithStudentAndMaterialAdapter: RecyclerView.Adapter<ScheduleWithStudentAndMaterialAdapter.ScheduleWithStudentAndMaterialViewHolder>() {
    var scheduleWithStudentAndMaterial: List<ScheduleWithStudentAndMaterial> = arrayListOf()

    class ScheduleWithStudentAndMaterialViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(sws: ScheduleWithStudentAndMaterial) {
            itemView.item_schedule_student_name.text = "${sws?.student?.nickName} - ${sws?.student?.lastName}, ${sws?.student?.firstName}"
            itemView.item_schedule_lesson_title.text = sws.studentLessonMaterial?.lessonMaterial?.title ?: "No Book"
            itemView.item_schedule_student_status.text = sws.student.status.toString()
            itemView.item_schedule_status.text = sws.schedule?.status.toString()
            itemView.item_schedule_date.text = "June 14, 2018"
            itemView.item_schedule_time.text = "${sws.schedule?.timeStart} - ${sws.schedule?.timeEnd}"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleWithStudentAndMaterialViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule_with_student_and_materials, parent, false)

        return ScheduleWithStudentAndMaterialViewHolder(v)
    }

    override fun getItemCount(): Int {
       return scheduleWithStudentAndMaterial.size
    }

    override fun onBindViewHolder(holder: ScheduleWithStudentAndMaterialViewHolder, position: Int) {
        holder.bind(scheduleWithStudentAndMaterial[position])
    }

    fun submitList(scheduleWithStudentAndMaterial: List<ScheduleWithStudentAndMaterial>) {
        this.scheduleWithStudentAndMaterial = scheduleWithStudentAndMaterial
    }
}