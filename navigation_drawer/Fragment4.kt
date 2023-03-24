package com.fdananda.kotlinnavigationdraweractivity.ui.fragment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fdananda.kotlinnavigationdraweractivity.databinding.Fragment4Binding

class Fragment4 : Fragment() {

    private var _binding: Fragment4Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(Fragment4ViewModel::class.java)

        _binding = Fragment4Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFragment4
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}