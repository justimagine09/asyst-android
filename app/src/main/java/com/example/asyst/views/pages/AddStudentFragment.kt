package com.example.asyst.views.pages

import android.app.DatePickerDialog
import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.asyst.Helpers.Validators
import com.example.asyst.R
import com.example.asyst.database.entities.StudentEntity
import com.example.asyst.models.enums.EGender
import com.example.asyst.models.enums.EStudentStatus
import com.example.asyst.viewModels.StudentViewModel
import com.example.asyst.views.controllers.ImageSwitcherViewController
import kotlinx.android.synthetic.main.fragment_add_student.*
import kotlinx.android.synthetic.main.fragment_add_student.view.*
import kotlinx.coroutines.*
import java.util.*


class AddStudentFragment : Fragment() {
    lateinit var root: View
    lateinit var genderImagerSwitcher: ImageSwitcherViewController
    lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_add_student, container, false)

        activity?.let {
            studentViewModel = ViewModelProvider(it).get(StudentViewModel::class.java)
        }

        setupGenderImageSwitcher()
        setupBirthDate()
        setupSubmitButton()

        return root
    }

    private fun setupSubmitButton() {
        root.add_student_form_submit_button.setOnClickListener {
            addStudent()
        }
    }

    private fun addStudent() {
        GlobalScope.launch {
            val studentEntity = StudentEntity(
                firstName = root.add_student_form_first_name.text.toString(),
                lastName = root.add_student_form_first_name.text.toString(),
                nickName = root.add_student_form_first_name.text.toString(),
                gender = if(genderImagerSwitcher.currentPosition() == 0) EGender.MALE else EGender.FEMALE,
                status = if(root.add_student_form_status.isChecked) EStudentStatus.REGULAR else EStudentStatus.TRIAL,
                timeStamp = Date()
            )

            try {
                studentViewModel.insert(studentEntity)

                GlobalScope.launch(Dispatchers.Main) {
                    Toast.makeText(root.context, "Student Successfully Added", Toast.LENGTH_SHORT).show()
                }
            } catch (e: SQLiteException) {
                Log.d("[addStudent]","failed to add or update student", e)
            }
        }
    }

    private fun setupBirthDate() {

        root.add_student_form_birth_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(root.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                root.add_student_form_birth_date.setText("$year/$monthOfYear/$day", TextView.BufferType.EDITABLE)
            }, year, month, day)

            dpd.show()


        }
    }

    private fun setupGenderImageSwitcher() {
        genderImagerSwitcher = ImageSwitcherViewController(root.context, root.images_switcher_gender, arrayOf(R.drawable.avatar_male, R.drawable.avatar_female), R.anim.expand_in)

        root.images_switcher_gender_swap_icon.setOnClickListener {
            genderImagerSwitcher.next()
        }
    }

    private fun checkIfValid(): Boolean {

        if(!Validators.required(root.add_student_form_first_name.text.toString())) {
            root.add_student_form_first_name.error = "Required field"
            return false
        }

        if(!Validators.required(root.add_student_form_last_name.text.toString())) {
            root.add_student_form_last_name.error = "Required field"
            return false
        }

        if(!Validators.required(root.add_student_form_nick_name.text.toString())) {
            root.add_student_form_nick_name.error = "Required field"
            return false
        }

        return true
    }
}
