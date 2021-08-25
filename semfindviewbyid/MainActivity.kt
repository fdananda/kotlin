package com.fdananda.gitkotlinsemfinfviewbyid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeText (view: View){
        if (!editText.text.toString().equals("")){
            textView.setText(editText.text.toString())
        }else{
            textView.setText("Campo obrigatório não preenchido!")
        }
    }
}
