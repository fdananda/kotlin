package com.fdananda.kotlinvideoviewrrating

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewEstrelas: TextView?
        val ratingBarEstrelas: RatingBar?

        ratingBarEstrelas = findViewById(R.id.ratingBar)
        textViewEstrelas = findViewById(R.id.textViewNotasEstrelas)

        ratingBarEstrelas.setOnRatingBarChangeListener(OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val numeroEstrelas = rating.toInt()
            var textoAvaliacao: String? = null
            when (numeroEstrelas) {
                1 -> textoAvaliacao = "1 Estrela"
                2 -> textoAvaliacao = "2 Estrelas"
                3 -> textoAvaliacao = "3 Estrelas"
                4 -> textoAvaliacao = "4 Estrelas"
                5 -> textoAvaliacao = "5 Estrelas"
            }
            textViewEstrelas.setText(textoAvaliacao)
        })
    }

    fun abrirVideo(view: View?) {
        val intent = Intent(applicationContext, VideoActivity::class.java)
        startActivity(intent)
    }
}
