package com.fdananda.kotlinnavegao

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirActivitySimples(view: View?) {
        val intent = Intent(this, SimplesActivity::class.java)
        startActivity(intent)
    }

    fun abrirActivityComDados(view: View?) {

        //Componentes passagem de dados
        val editTextAtributoTexto: EditText?
        val editTextAtributoNumero: EditText?

        //Componentes passagem de dados
        editTextAtributoTexto    = findViewById(R.id.editTextAtributoTexto)
        editTextAtributoNumero   = findViewById(R.id.editTextAtributoNumero)

        val atributoTexto: String = editTextAtributoTexto.getText().toString()
        val textoNumero: String = editTextAtributoNumero.getText().toString()
        if (!atributoTexto.isEmpty()) {
            if (!textoNumero.isEmpty()) {
                try {
                    val atributoNumero = textoNumero.toInt()
                    val intent = Intent(applicationContext, ComDadosActivity::class.java)
                    intent.putExtra("Texto", atributoTexto)
                    intent.putExtra("Numero", atributoNumero)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(
                        applicationContext,
                        "Preencha um número válido!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Preencha o número!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Preencha o texto",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun abrirActivityComObjeto(view: View?) {

        //Componentes passagem de objetos
        val editTextAtributoTextoObjeto: EditText?
        val editTextAtributoNumeroObjeto: EditText?

        //Componentes passagem de objetos
        editTextAtributoTextoObjeto     = findViewById(R.id.editTextAtributoTextoObjeto)
        editTextAtributoNumeroObjeto    = findViewById(R.id.editTextAtributoNumeroObjeto)

        val atributoTexto: String = editTextAtributoTextoObjeto.getText().toString()
        val textoNumero: String = editTextAtributoNumeroObjeto.getText().toString()
        if (!atributoTexto.isEmpty()) {
            if (!textoNumero.isEmpty()) {
                try {
                    val atributoNumero = textoNumero.toInt()
                    val objeto = Objeto(atributoTexto, atributoNumero)
                    val intent = Intent(applicationContext, ComDadosActivity::class.java)
                    intent.putExtra("Texto", atributoTexto)
                    intent.putExtra("Numero", atributoNumero)
                    intent.putExtra("objeto", objeto)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(
                        applicationContext,
                        "Preencha um número válido!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Preencha o número!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Preencha o texto",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
