package com.fdananda.gitkotlinwhen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView
    private lateinit var option: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.textView)
        option      = findViewById(R.id.editText)
        button      = findViewById(R.id.button)
    }

    fun chooseOption(view: View){
        var optionSelected = option.text.toString() //Variável como String

        if (!optionSelected.equals("")){
            var optionSelected = Integer.valueOf(option.text.toString()) //Variável como Inteiro
            //When funciona como o Switch
            var result: String = when(optionSelected){
                1, 2, 3, 4, 5 -> "Opção $optionSelected escolhida"
                else -> "Opção Inválida"
            }
            textResult.setText(result)
        }else{
            textResult.setText("Campo obrigatório não preenchido!")
        }
    }
}
