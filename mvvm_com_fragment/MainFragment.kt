package com.fdananda.kotlinviewmodel.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fdananda.kotlinviewmodel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
        ): View {

        val root: View = inflater.inflate(R.layout.fragment_main, container, false)
        val textView = root.findViewById<TextView>(R.id.text_home)
        val textIncremento = root.findViewById<TextView>(R.id.textViewIncremente)
        val mFab = root.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.homeViewModel()
        viewModel.getText()!!.observe(viewLifecycleOwner) { s -> textView.text = s }
        viewModel.getIncremento().observe(viewLifecycleOwner) { s -> textIncremento.text = s }

        mFab.setOnClickListener { viewModel.incrementar() }
        return root
    }

}
