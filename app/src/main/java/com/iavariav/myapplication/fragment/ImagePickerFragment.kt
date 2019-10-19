package com.iavariav.myapplication.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.iavariav.myapplication.R

/**
 * A simple [Fragment] subclass.
 */
class ImagePickerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_image_picker, container, false)

        val btn = view.findViewById<Button>(R.id.btn_image_picker)

        return view
    }


}
