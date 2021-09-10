package com.fdananda.gitkotlintoast

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fdananda.gitkotlintoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToastSimplesLong.setOnClickListener { abrirToastSimplesLong() }
        binding.buttonToastSimplesShort.setOnClickListener { abrirToastSimplesShort() }
        binding.buttonToastPersonalizado.setOnClickListener { abrirToastPersonalizado() }
        binding.buttonToastComLayout.setOnClickListener { abrirToastComLayout() }
    }

    private fun abrirToastSimplesLong() {
        Toast.makeText(
            applicationContext,
            "Exemplo de Toast Simples do tipo Long",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun abrirToastSimplesShort() {
        Toast.makeText(
            applicationContext,
            "Exemplo de Toast Simples do tipo Short",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun abrirToastPersonalizado() {
        val imagem = ImageView(applicationContext)
        imagem.setImageResource(android.R.drawable.btn_star_big_on)
        val texto = TextView(applicationContext)
        texto.setBackgroundResource(R.color.design_default_color_error)
        texto.setTextColor(resources.getColor(R.color.white))
        texto.setPadding(50, 50, 50, 50)
        texto.isAllCaps = true
        texto.text = "Exemplo de Toast Personalizado"
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        //toast.setView(imagem);
        toast.setView(texto)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }

    private fun abrirToastComLayout() {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast, null)
        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.setView(layout)
        toast.show()
    }
}
