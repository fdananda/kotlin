package com.fdananda.kotlinfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class DoisFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_dois, container, false)
        val buttonAbrirFragment1: Button?
        val umFragment: UmFragment?

        umFragment = UmFragment()
        buttonAbrirFragment1 = view.findViewById(R.id.buttonAbrirFragmentUm)
        buttonAbrirFragment1.setOnClickListener(View.OnClickListener {
            val transaction: FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayoutConteudo, umFragment)
            transaction.commit()
        })
        return view
    }
}
