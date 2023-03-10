package com.fdananda.kotlinmvvmbotao

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var texto: TextView
    private lateinit var texto2:TextView
    private lateinit var novoTexto: EditText
    private lateinit var novoTexto2:EditText
    private lateinit var buttonSubstituir: Button
    private lateinit var mainActivityVM: MainActivityVM
    private lateinit var maskUtil: MaskUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.textViewTexto)
        texto2 = findViewById(R.id.textViewTexto2)
        novoTexto = findViewById(R.id.editTextNovoTexto)
        novoTexto2 = findViewById(R.id.editTextNovoTexto2)
        buttonSubstituir = findViewById(R.id.buttonSubstituirTexto)
        mainActivityVM = ViewModelProvider(this).get(MainActivityVM::class.java)
        maskUtil = MaskUtil()

        ativarBotao()
    }

    private fun ativarBotao() {

        novoTexto.addTextChangedListener(maskUtil.insert(novoTexto))
        novoTexto.addTextChangedListener(habilitarBotao)
        novoTexto2.addTextChangedListener(habilitarBotao)
        mainActivityVM.ativarBotao()!!.observe(this
        ) { aBoolean -> buttonSubstituir.isEnabled = aBoolean!! }
    }

    private val habilitarBotao: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val texto1 = novoTexto.text.toString()
            val texto2 = novoTexto2.text.toString()
            if (texto1.isNotEmpty() && texto2.isNotEmpty()) {
                mainActivityVM.contarTexto(texto1, texto2)
            }
        }

        override fun afterTextChanged(s: Editable) {}
    }


    fun substituirTexto(view: View?) {
        val textoRecuperado = novoTexto.text.toString()
        if (textoRecuperado.isEmpty() || textoRecuperado === "") {
            Toast.makeText(this, "Preencha o campo!", Toast.LENGTH_SHORT).show()
        } else {
            mainActivityVM.enviarTexto(novoTexto.text.toString(), novoTexto2.text.toString())
            mainActivityVM.retornarTexto()!!.observe(this
            ) { s -> texto.text = s }
            mainActivityVM.retornarTexto2()!!.observe(this
            ) { s -> texto2.text = s }
        }
    }
}
