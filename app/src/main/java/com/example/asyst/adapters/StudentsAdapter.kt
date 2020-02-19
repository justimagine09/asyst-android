package com.example.asyst.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asyst.R
import com.example.asyst.database.linkers.Student

class StudentsAdapter: RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>() {
    var students: List<Student> = arrayListOf()

    class StudentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(student: Student) {
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)

        return StudentsViewHolder(v)
    }

    override fun getItemCount(): Int {
       return students.size
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(students[position])
    }

    fun submitList(student: List<Student>) {
        this.students = student
    }
}