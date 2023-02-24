package com.fdananda.kotlinseekbar

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekBar: SeekBar? = null
        var textoProgresso: TextView? = null
        var botaoProgresso: Button? = null

        var seekBarDiscrete: SeekBar? = null
        var textoProgressoDiscrete: TextView? = null
        var botaoProgressoDiscrete: Button? = null

        seekBar = findViewById(R.id.seekBar)
        textoProgresso = findViewById(R.id.textViewTexto)
        botaoProgresso = findViewById(R.id.buttonProgresso)

        seekBarDiscrete = findViewById(R.id.seekBarDiscrete)
        textoProgressoDiscrete = findViewById(R.id.textViewTextoProgressoDiscrete)
        botaoProgressoDiscrete = findViewById(R.id.buttonProgressoDiscrete)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textoProgresso.setVisibility(View.VISIBLE)
                textoProgresso.setText("Progresso: " + progress + " / " + seekBar.max)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        botaoProgresso.setOnClickListener {
            val texto = TextView(applicationContext)
            texto.setBackgroundResource(android.R.color.black)
            texto.setTextColor(resources.getColor(android.R.color.white))
            texto.setPadding(25, 25, 25, 25)
            texto.isAllCaps = true
            texto.textSize = 20f
            texto.text = "Progresso recuperado: " + seekBar.getProgress()
            val toast = Toast(applicationContext)
            toast.duration = Toast.LENGTH_LONG
            //toast.setView(imagem);
            toast.setView(texto)
            toast.setGravity(Gravity.BOTTOM, 0, 80)
            toast.show()
        }

        seekBarDiscrete.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textoProgressoDiscrete.setVisibility(View.VISIBLE)
                textoProgressoDiscrete.setText("Progresso: " + progress + " / " + seekBar.max)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    fun recuperarProgressoDiscrete(view: View?) {

        var seekBarDiscrete: SeekBar? = null
        seekBarDiscrete = findViewById(R.id.seekBarDiscrete)

        val texto = TextView(applicationContext)
        texto.setBackgroundResource(android.R.color.black)
        texto.setTextColor(resources.getColor(android.R.color.white))
        texto.setPadding(25, 25, 25, 25)
        texto.isAllCaps = true
        texto.textSize = 20f
        texto.text = "Progresso recuperado: " + seekBarDiscrete.getProgress()
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        //toast.setView(imagem);
        toast.setView(texto)
        toast.setGravity(Gravity.BOTTOM, 0, 80)
        toast.show()
    }
}
