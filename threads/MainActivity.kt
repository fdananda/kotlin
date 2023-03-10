package com.fdananda.kotlinthreads

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var buttonThreadPrincipal: Button? = null
    var buttonMyThread: Button? = null
    var buttonMyRunnable: Button? = null
    var textViewMyRunnableResultado: TextView? = null
    var stop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMyRunnable = findViewById(R.id.buttonMyRunnable)
        buttonThreadPrincipal = findViewById(R.id.buttonThreadPrincipal)
        buttonMyThread = findViewById(R.id.buttonMyThread)
        textViewMyRunnableResultado = findViewById(R.id.textViewMyRunnableResultado)
    }


    //Utilizando a Thread principal - evitar
    fun startThreadPrincipal(view: View?) {
        for (i in 0..15) {
            Log.d("Thread", "Passos da Thread Principal:$i")
            buttonThreadPrincipal!!.text = "Thread Principal: $i"
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    //Utilizando a Thread criada na classe MyThread
    fun startMyThread(view: View?) {
        val myThread = MyThread(buttonMyThread!!, MainActivity())
        myThread.start()
    }

    //Utilizando a Thread criada na classe MyThead
    fun startMyRunnable(view: View?) {
        stop = false
        val myRunnable = MyRunnable(stop, buttonMyRunnable!!, textViewMyRunnableResultado!!)
        Thread(myRunnable).start()
    }

    internal class MyRunnable(stop: Boolean, buttonMyRunnable: Button, textViewMyRunnableResultado: TextView) : Runnable {

        private var numeroMyRunnable = 0
        private val handler: Handler = Handler()
        private var stop = stop
        private var buttonMyRunnable = buttonMyRunnable
        private var textViewMyRunnableResultado = textViewMyRunnableResultado


        override fun run() {
            for (i in 0..15) {
                if (stop) return
                Log.d("Thread", "Passos da My Runnable:$i")
                numeroMyRunnable = i
                Runnable { buttonMyRunnable.setText("My Runnable: $numeroMyRunnable") }
                handler.postDelayed(Runnable {
                    textViewMyRunnableResultado.setVisibility(View.VISIBLE)
                    textViewMyRunnableResultado.setText("My Runnable: $numeroMyRunnable")
                    textViewMyRunnableResultado.setGravity(1)
                }, 5000)
                handler.postDelayed(
                    Runnable { textViewMyRunnableResultado.setVisibility(View.GONE) },
                    16000
                )
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }

    class MyThread(buttonMyThread: Button, activity: MainActivity) : Thread() {
        private var numeroMyThread = 0
        private var buttonMyThread = buttonMyThread
        private var activity = activity

        override fun run() {
            for (i in 0..15) {
                numeroMyThread = i
                Log.d("Thread", "Passos da My Thread:$i")
                activity.runOnUiThread(Runnable { buttonMyThread.setText("My Thread: $numeroMyThread") })
                try {
                    sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            super.run()
        }
    }
}
