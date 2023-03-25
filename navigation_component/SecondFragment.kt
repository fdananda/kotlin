package com.fdananda.kotlinnavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

class SecondFragment : Fragment() {

    private lateinit var textView2: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textView2 = view.findViewById(R.id.textView2)
        textView2.setText("Fragment " + arguments?.getInt("number").toString())
        textView2.setOnClickListener{ findNavController(view).navigate(R.id.navigation_to_firstFragment) }
        return view
    }
}
