package com.fdananda.kotlinasynctask

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBarVolume)
    }

    fun start(view: View?) {
        val myAsyncTask = MyAsyncTask(seekBar)
        myAsyncTask.execute(10)
    }

    //<Parâmetro de entrada, Progresso, Retorno>
    open class MyAsyncTask(seekBar: SeekBar): AsyncTask<Int?, Int?, String>() {

        var seekBar = seekBar
        //var textView = textView
        override fun onPreExecute() {
            super.onPreExecute()
            seekBar.setVisibility(View.VISIBLE)
        }

        override fun doInBackground(vararg params: Int?): String {
            val progresso = params[0]
            for (i in 0..progresso!!) {
                publishProgress(i)
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            return "OK"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            seekBar.setProgress(values[0]!!)
            Log.d("Progresso", "Valor de progresso: ${values[0].toString()}")

        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            seekBar.setProgress(0)
            seekBar.setVisibility(View.INVISIBLE)
        }
    }
}
