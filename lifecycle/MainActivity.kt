package com.fdananda.kotlinactivitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Lifecycle", "On Create")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "On Destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "On Restart")
    }
}
