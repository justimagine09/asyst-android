package com.example.asyst.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asyst.R
import com.example.asyst.database.linkers.ScheduleWithStudentAndMaterial
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EStudentStatus
import kotlinx.android.synthetic.main.item_schedule_with_student_and_materials.view.*

class ScheduleWithStudentAndMaterialAdapter: RecyclerView.Adapter<ScheduleWithStudentAndMaterialAdapter.ScheduleWithStudentAndMaterialViewHolder>() {
    var scheduleWithStudentAndMaterial: List<ScheduleWithStudentAndMaterial> = arrayListOf()

    class ScheduleWithStudentAndMaterialViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(sws: ScheduleWithStudentAndMaterial) {
            itemView.item_schedule_student_name.text = "${sws?.student?.nickName} - ${sws?.student?.lastName}, ${sws?.student?.firstName}"
            itemView.item_schedule_time.text = "${sws.schedule?.timeStart} PM - ${sws.schedule?.timeEnd} PM"
            itemView.item_schedule_avatar.setImageResource(if(sws.student.gender == EGender.MALE) R.drawable.avatar_male else R.drawable.avatar_female)

            Log.d("xx","${sws.student.gender} == ${EStudentStatus.TRIAL}")
            if(sws.student.status == EStudentStatus.REGULAR) {
                itemView.item_schedule_trial_star.visibility = View.GONE
            }
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