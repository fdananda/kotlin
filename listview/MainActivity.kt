package com.fdananda.kotlinlistview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val opcoes = arrayOf(
        "Opção 1", "Opção 2", "Opção 3", "Opção 4", "Opção 5",
        "Opção 6", "Opção 7", "Opção 8", "Opção 9", "Opção 10",
        "Opção 11", "Opção 12", "Opção 13", "Opção 14", "Opção 15",
        "Opção 16", "Opção 17", "Opção 18", "Opção 19", "Opção 20"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewOpcoes: ListView?
        listViewOpcoes = findViewById(R.id.listView)

        //Passo 1 - Criar um adaptador

        //Passo 1 - Criar um adaptador
        val adapter = ArrayAdapter(
            applicationContext,  //Context
            R.layout.adapter,  //Layout que será utilizado
            R.id.textViewAtributo1,  //item dentro do layout que será preenchido com a lista
            opcoes //lista
        )

        //Passo 2 - Configurar o adapatador na lista
        listViewOpcoes.setAdapter(adapter)


        //Passo 3 - Adicionar evento de clique ao item da lista
        listViewOpcoes.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val opcaoSelecionda = listViewOpcoes.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, opcaoSelecionda, Toast.LENGTH_LONG).show()
        })
    }
}
