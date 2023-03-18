package com.fdananda.kotlinnavegacaoactivities2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View?) {
        startActivity(Intent("com.fdananda.kotlinnavegacaoactivities2.SecondActivity"))
    }
}
