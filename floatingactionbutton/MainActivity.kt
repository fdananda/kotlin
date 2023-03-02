package com.fdananda.kotlinfloatingactionbutton

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewTexto: TextView = findViewById(R.id.textViewTexto)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                textViewTexto.setText("FAB foi clicado!")
                Snackbar.make(view!!, "FAB foi clicado!", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Confirmar", object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            Toast.makeText(
                                this@MainActivity,
                                "Ação confirmada!",
                                Toast.LENGTH_SHORT
                            ).show()
                            textViewTexto.setText("Texto original retornardo")
                        }
                    }).show()
            }
        })
    }
}
