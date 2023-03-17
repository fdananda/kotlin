package com.fdananda.kotlinprogressdialog

import android.app.ProgressDialog
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()

        //Dialog de progresso modal
        progressDialog = ProgressDialog.show(this, "Favor aguardar", "Processando requisição", true)

        //Contador para encerrar a dialog
        val countDownTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(l: Long) {}
            override fun onFinish() {
                progressDialog.dismiss()
            }
        }.start()
    }
}
