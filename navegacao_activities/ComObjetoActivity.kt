package com.fdananda.kotlinnavegao

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComObjetoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_com_objeto)

        val textViewAtributoTextoObjeto: TextView?
        val textViewAtributoNumeroObjeto: TextView?

        textViewAtributoTextoObjeto = findViewById(R.id.textViewTextoObjeto)
        textViewAtributoNumeroObjeto = findViewById(R.id.textViewNumeroObjeto)

        val dadosRecebidos = intent.extras

        val objeto = dadosRecebidos!!.getSerializable("objeto") as Objeto?
        val textoAtributoTexto = objeto!!.getAtributoObjetoTexto()
        val textoAtributoNumero = objeto.getAtributoObjetoNumero()

        textViewAtributoTextoObjeto.setText(textoAtributoTexto)
        textViewAtributoNumeroObjeto.setText(textoAtributoNumero.toString())
    }

    fun voltarMainActivity(view: View?) {
        finish()
    }
}
