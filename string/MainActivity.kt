package com.fdananda.kotlinstring

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName        = findViewById(R.id.editTextName)
        textViewResultado   = findViewById(R.id.textViewResult)
    }

    fun getName(view: View?) {
        if (!editTextName.text.toString().isEmpty() || editTextName.text.toString() != "") {

            //Nome completo
            val fullName = editTextName.text.toString()

            //Quantidade de nomes
            val array = fullName.split(" ").toTypedArray()
            val qtdNames = array.size

            //Inicias
            var initials = ""
            for (i in 0 until qtdNames) {
                initials += array[i][0].toString()
            }

            //Primeiro e último nome
            val nameSurname = if (array.size > 1) {
                array[0] + " " + array[array.size - 1]
            } else {
                array[0]
            }
            var resultado = """
            Nome completo: $fullName
            Quantidade de nomes: $qtdNames
            Iniciais: $initials
            Primeiro Nome e último sobrenome: $nameSurname
            """

            //Desmembramento de nomes
            val name = arrayOfNulls<String>(qtdNames)
            var names: String
            for (i in 0 until qtdNames) {
                name[i] = array[i]
                names = "Nome " + (i + 1) + ": " + name[i]
                resultado = """
                $resultado
                $names
                """
            }
            textViewResultado.setTextColor(resources.getColor(R.color.black))
            textViewResultado.text = resultado
        } else {
            textViewResultado.text = "Campo obrigatório não preenchido!"

        }
    }
}
