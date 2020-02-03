package com.example.asyst.views.pages


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.asyst.R
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val date = Date(1580621436857)
        Toast.makeText(root.context,date.toString(), Toast.LENGTH_LONG).show()
        // Inflate the layout for this fragment
        return root
    }


}
