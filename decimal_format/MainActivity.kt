package com.fdananda.kotlindecimalformat

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumeroDigitado: EditText
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResultado      = findViewById(R.id.textViewResultado)
        editTextNumeroDigitado = findViewById(R.id.editTextNumeroDigitado)
    }

    fun somarFormatar(view: View?) {
        val numeroDigitado = editTextNumeroDigitado.text.toString()
        val numeroDigitadoFormatado = numeroDigitado.replace(",".toRegex(), ".")
        if (numeroDigitado.isEmpty() || numeroDigitado === "") {
            textViewResultado.text = "Digite um número válido"
        } else {
            val somaSemFormatacao =
                java.lang.Double.valueOf(numeroDigitadoFormatado).toDouble() + 3.14159265359
            val resultadoSemFormatacao = somaSemFormatacao.toString()
            val decimalFormat2numeros = DecimalFormat("0.##")
            val decimalFormat2numerosComZero = DecimalFormat("0.00")
            val resultado2numeros: String = decimalFormat2numeros.format(somaSemFormatacao)
            val resultado2numerosComZero: String =
                decimalFormat2numerosComZero.format(somaSemFormatacao)
            val decimalFormat3numeros = DecimalFormat("0.000")
            val resultado3numeros: String = decimalFormat3numeros.format(somaSemFormatacao)
            val decimalFormat4numeros = DecimalFormat("0.0000")
            val resultado4numeros: String = decimalFormat4numeros.format(somaSemFormatacao)
            val resultado = """
            Soma sem formatação: $resultadoSemFormatacao
            Soma com 2 casas decimais sem 0: $resultado2numeros
            Soma com 2 casas decimais com 0: $resultado2numerosComZero
            Soma com 3 casas decimais com 0: $resultado3numeros
            Soma com 4 casas decimais com 0: $resultado4numeros
            """.trimIndent()
            textViewResultado.text = resultado
        }
    }
}
