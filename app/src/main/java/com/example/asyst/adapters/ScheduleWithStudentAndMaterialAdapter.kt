package com.example.asyst.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asyst.database.linkers.ScheduleWithStudent
import kotlinx.android.synthetic.main.item_schedule_with_student_and_materials.view.*

class ScheduleWithStudentAndMaterialAdapter: RecyclerView.Adapter<ScheduleWithStudentAndMaterialAdapter.ScheduleWithStudentAndMaterialViewHolder>() {
    var scheduleWIthStudent: List<ScheduleWithStudent> = arrayListOf()

    class ScheduleWithStudentAndMaterialViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(sws: ScheduleWithStudent) {
            itemView.item_schedule_student_name.text = "${sws?.student?.nickName} - ${sws?.student?.lastName}, ${sws?.student?.firstName}"
            itemView.item_schedule_lesson_title.text = sws.studentLessonMaterial?.lessonMaterial?.title ?: "No Book"
            itemView.item_schedule_student_status.text = sws.student.status.toString()
            itemView.item_schedule_status.text = sws.scheduleEntity?.status.toString()
            itemView.item_schedule_date.text = "June 14, 2018"
            itemView.item_schedule_time.text = "${sws.scheduleEntity?.timeStart} - ${sws.scheduleEntity?.timeEnd}"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleWithStudentAndMaterialViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ScheduleWithStudentAndMaterialViewHolder(parent)
    }

    override fun getItemCount(): Int {
       return scheduleWIthStudent.size
    }

    override fun onBindViewHolder(holder: ScheduleWithStudentAndMaterialViewHolder, position: Int) {
        holder.bind(scheduleWIthStudent[position])
    }

    fun submitList(scheduleWIthStudent: List<ScheduleWithStudent>) {
        this.scheduleWIthStudent = scheduleWIthStudent
    }
}