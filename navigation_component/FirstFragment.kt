package com.fdananda.kotlinnavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

class FirstFragment : Fragment() {

    private lateinit var textView1: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        textView1 = view.findViewById(R.id.textView1)
        textView1.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("number", 2)
            findNavController(view).navigate(R.id.navigation_to_secondFragment, bundle)
        }
        return view
    }
}
