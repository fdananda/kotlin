package com.fdananda.gitkotlinsorteioarray

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var texto: TextView
    private val opcoes = arrayOf("Opção 1", "Opção 2", "Opção 3", "Opção 4", "Opção 5",
            "Opção 6", "Opção 7", "Opção 8", "Opção 9", "Opção 10")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sortear(view: View) {
        texto = findViewById(R.id.textViewTexto)
        val numeroSorteado = Random().nextInt(opcoes.size)
        texto.text = opcoes[numeroSorteado]
    }
}
