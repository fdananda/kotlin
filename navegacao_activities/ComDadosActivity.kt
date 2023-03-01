package com.fdananda.kotlinnavegao

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComDadosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_com_dados)

        val textViewAtributoTexto: TextView?
        val textViewAtributoNumero: TextView?

        textViewAtributoTexto = findViewById(R.id.textViewTexto)
        textViewAtributoNumero = findViewById(R.id.textViewNumero)

        val dadosRecebidos = intent.extras
        val textoAtributoTexto = dadosRecebidos!!.getString("Texto")
        val textoAtributoNumero = dadosRecebidos.getInt("Numero")

        textViewAtributoTexto.setText(textoAtributoTexto)
        textViewAtributoNumero.setText(textoAtributoNumero.toString())
    }

    fun voltarMainActivity(view: View?) {
        finish()
    }
}
