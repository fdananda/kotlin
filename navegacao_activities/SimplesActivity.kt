package com.fdananda.kotlinnavegao

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SimplesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simples)
    }

    fun voltarMainActivity(view: View?) {
        finish()
    }
}
