package com.fdananda.kotlinonactivityresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    private lateinit var mEditTextNumber1: EditText
    private lateinit var mEditTextNumber2:EditText
    private lateinit var mTextViewResult: TextView
    private val CALCULATE_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextNumber1 = findViewById(R.id.edittext_number1)
        mEditTextNumber2 = findViewById(R.id.edittext_number2)
        mTextViewResult  = findViewById(R.id.textView)
    }

    fun openActivity2(view: View?) {
        if (mEditTextNumber1.text.toString() != "" && mEditTextNumber2.text.toString() != "") {
            val number1 = mEditTextNumber1.text.toString().toInt()
            val number2 = mEditTextNumber2.text.toString().toInt()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("number1", number1)
            intent.putExtra("number2", number2)
            startActivityForResult(intent, CALCULATE_REQUEST_CODE)
        } else {
            mTextViewResult.text = "Campo obrigatório não preenchido"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CALCULATE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val operacao = data!!.getStringExtra("operacao")
                val result = data.getIntExtra("result", 0)
                mTextViewResult.text = operacao + result.toString()
            } else if (resultCode == RESULT_CANCELED) {
                mTextViewResult.text = "Nenhuma operação selecionada"
            }
        }
    }
}
