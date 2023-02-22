package com.fdananda.kotlinprogressbar

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var progresso = 0
    private var progressoCircular = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun acionarProgressBarHorizontal(view: View?) {
        val textoProgresso: String
        var barraProgressoHorizontal: ProgressBar? = null
        var textoProgressoHorizontal: TextView? = null

        textoProgressoHorizontal = findViewById(R.id.textViewProgressoHorizontal);
        barraProgressoHorizontal = findViewById(R.id.progressBarHorizontal);
        barraProgressoHorizontal.setVisibility(View.GONE);
        textoProgressoHorizontal.setVisibility(View.GONE);

        if (barraProgressoHorizontal!!.getProgress() !== 100) {
            barraProgressoHorizontal!!.setVisibility(View.VISIBLE)
            textoProgressoHorizontal?.setVisibility(View.VISIBLE)
            barraProgressoHorizontal.setProgress(progresso)
            textoProgresso = progresso.toString()
            textoProgressoHorizontal?.setText(textoProgresso)
            progresso = progresso + 25
            textoProgressoHorizontal?.setText(textoProgresso)
        } else {
            textoProgresso = "Progresso concluído.\nClique para reiniciar"
            textoProgressoHorizontal?.setText(textoProgresso)
            barraProgressoHorizontal!!.setVisibility(View.GONE)
            progresso = 0
            barraProgressoHorizontal.setProgress(progresso)
        }
    }

    fun acionarProgressBarCircular(view: View?) {
        val textoProgresso: String
        var barraProgressoCircular: ProgressBar? = null
        var textoProgressoCircular: TextView? = null

        textoProgressoCircular = findViewById(R.id.textViewProgressoCircular);
        barraProgressoCircular   = findViewById(R.id.progressBarCircular);
        barraProgressoCircular.setVisibility(View.GONE);
        textoProgressoCircular.setVisibility(View.GONE);


        if (progressoCircular > 100) {
            textoProgresso = "Progresso concluído.\nClique para reiniciar"
            textoProgressoCircular?.setText(textoProgresso)
            barraProgressoCircular?.setVisibility(View.GONE)
            progressoCircular = 0
            barraProgressoCircular?.setProgress(progressoCircular)
        } else {
            barraProgressoCircular?.setVisibility(View.VISIBLE)
            textoProgressoCircular?.setVisibility(View.VISIBLE)
            barraProgressoCircular?.setProgress(progressoCircular)
            textoProgresso = progressoCircular.toString()
            textoProgressoCircular?.setText(textoProgresso)
            progressoCircular = progressoCircular + 10
            textoProgressoCircular?.setText(textoProgresso)
        }
    }
}
