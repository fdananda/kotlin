package com.fdananda.kotlinfragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private var umFragment: UmFragment? = null
    private var doisFragment: DoisFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        umFragment = UmFragment()
        doisFragment = DoisFragment()
        
        //Configura fragment que será apresentado inicialmente
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutConteudo, umFragment!!)
        transaction.commit()
    }

    fun abrirFragment1DaActivity(view: View?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutConteudo, umFragment!!)
        transaction.commit()
    }

    fun abrirFragment2DaActivity(view: View?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutConteudo, doisFragment!!)
        transaction.commit()
    }
}
