package com.fdananda.gitkotlinnullsafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var text1: String = null  // Erro, pois por padrão não pode ser vazio - NullPointerException (non null)
        var text2: String? = null // O null safe permite que a variável seja vazia - ?  Operador de chamada de segura
        var text3: String? = null

        //text2 = "Fernanda"
        text3 = "Moreira"

        textView.setText(text2?.length.toString())
        textView2.setText(text2.toString())
        textView3.setText(text3!!.toString()) //A exclamação dupla não aceita variável vazia - Not-Null
    }
}
