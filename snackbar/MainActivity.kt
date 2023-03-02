package com.fdananda.kotlinsnackbar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirSnackbar(view: View) {
        Snackbar.make(view, "Texto da SnackBar", Snackbar.LENGTH_INDEFINITE)
            .setAction("Confirmar", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Ação confirmada!", Toast.LENGTH_SHORT).show()
                }
            }).setActionTextColor(view.getResources().getColor(R.color.white))
            .setBackgroundTint(view.getResources().getColor(R.color.design_default_color_primary))
            .show()
    }
}
