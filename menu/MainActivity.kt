package com.fdananda.kotlinmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var textViewOpcaoSelecionada: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Apresenta o menu na Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Trata a seleção dos itens da Toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        textViewOpcaoSelecionada = findViewById(R.id.textViewOpcaoSelecionada)
        when (item.getItemId()) {
            R.id.toast1 -> {
                textViewOpcaoSelecionada!!.setText("Selecionada a opção Toast 1")
                Toast.makeText(this, "Selecionada a opção Toast 1", Toast.LENGTH_SHORT).show()
            }
            R.id.toast2 -> {
                textViewOpcaoSelecionada!!.setText("Selecionada a opção Toast 2")
                Toast.makeText(this, "Selecionada a opção Toast 2", Toast.LENGTH_SHORT).show()
            }
            R.id.toast3 -> {
                textViewOpcaoSelecionada!!.setText("Selecionada a opção Toast 3")
                Toast.makeText(this, "Selecionada a opção Toast 3", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
