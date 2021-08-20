package com.fdananda.gitkotlinsorteio

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun random (view: View){
        var textView = findViewById(R.id.textView2) as TextView
        val randomNumber: Int = Random().nextInt(11)
        textView.setText("O número sorteado é: $randomNumber" )
    }
}
