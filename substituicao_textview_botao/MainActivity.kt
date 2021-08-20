package com.fdananda.primeiroprojetokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeText (view: View){
        var editText = findViewById(R.id.editText) as EditText
        var textView = findViewById(R.id.textView) as TextView

        if (!editText.text.isEmpty()){
            textView.setText(editText.text)
        }else{
            textView.setText("Campo obrigatório não preenchido!")
        }
    }
}
