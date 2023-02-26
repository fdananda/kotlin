package com.fdananda.kotlinlistviewcustomizado

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private fun criarObjetos(): ArrayList<Objeto>? {
        val objetos = ArrayList<Objeto>()
        val objeto1 = Objeto("Título 1", "Descrição do título 1")
        objetos.add(objeto1)
        val objeto2 = Objeto("Título 2", "Descrição do título 2")
        objetos.add(objeto2)
        val objeto3 = Objeto("Título 3", "Descrição do título 3")
        objetos.add(objeto3)
        val objeto4 = Objeto("Título 4", "Descrição do título 4")
        objetos.add(objeto4)
        val objeto5 = Objeto("Título 5", "Descrição do título 5")
        objetos.add(objeto5)
        val objeto6 = Objeto("Título 6", "Descrição do título 6")
        objetos.add(objeto6)
        val objeto7 = Objeto("Título 7", "Descrição do título 7")
        objetos.add(objeto7)
        return objetos
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewOpcoes: ListView? = null
        listViewOpcoes = findViewById(R.id.listView)

        val objetos = criarObjetos()
        val adapter: ArrayAdapter<*> = AdapterCustomizado(this, objetos!!)
        listViewOpcoes.setAdapter(adapter)

        listViewOpcoes.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val opcaoSelecionada = """
                ${objetos[position].getAtributo1().toString()}
                ${objetos[position].getAtributo2()}
                """.trimIndent()
            Toast.makeText(applicationContext, opcaoSelecionada, Toast.LENGTH_LONG).show()
            Log.i("OPÇÃO", "OPÇÃO SELECIONADA: $opcaoSelecionada")
        })

    }
}
