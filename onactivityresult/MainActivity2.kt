package com.fdananda.kotlinonactivityresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2:EditText
    private lateinit var intentResult: Intent
    private var number1 = 0
    private var number2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intentResult = Intent()
        editTextNumber1 = findViewById(R.id.edittext_number1_a2)
        editTextNumber2 = findViewById(R.id.edittext_number2_a2)

        val intent = intent
        number1 = intent.getIntExtra("number1", 0)
        number2 = intent.getIntExtra("number2", 0)

        editTextNumber1.setText(number1.toString())
        editTextNumber2.setText(number2.toString())
    }

    fun add(view: View?) {
        val result = number1 + number2
        intentResult.putExtra("operacao", "Soma: ")
        intentResult.putExtra("result", result)
        setResult(RESULT_OK, intentResult)
        finish()
    }

    operator fun minus(view: View?) {
        val result = number1 - number2
        intentResult.putExtra("operacao", "Subtração: ")
        intentResult.putExtra("result", result)
        setResult(RESULT_OK, intentResult)
        finish()
    }

    fun multiply(view: View?) {
        val result = number1 * number2
        intentResult.putExtra("operacao", "Multiplicação: ")
        intentResult.putExtra("result", result)
        setResult(RESULT_OK, intentResult)
        finish()
    }

    fun divide(view: View?) {
        val result = number1 / number2
        intentResult.putExtra("operacao", "Divisão: ")
        intentResult.putExtra("result", result)
        setResult(RESULT_OK, intentResult)
        finish()
    }
}
