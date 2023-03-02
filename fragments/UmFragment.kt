package com.fdananda.kotlinfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class UmFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val buttonAbrirFragment2: Button?
        val doisFragment: DoisFragment?

        val view: View = inflater.inflate(R.layout.fragment_um, container, false)
        doisFragment = DoisFragment()
        buttonAbrirFragment2 = view.findViewById(R.id.buttonAbrirFragmentDois)
        buttonAbrirFragment2.setOnClickListener(View.OnClickListener {
            val transaction: FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayoutConteudo, doisFragment)
            transaction.commit()
        })
        return view
    }
}
