package com.fdananda.kotlinvideoviewrrating

import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        var videoView: VideoView? = null

        supportActionBar!!.hide()

        val view: View = window.decorView
        //val configTela: Int = view.SYSTEM_UI_FLAG_FULLSCREEN
        //view.setSystemUiVisibility(configTela)

        videoView = findViewById(R.id.videoView)

        videoView.setMediaController(MediaController(this))
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.video)
        videoView.start()
    }
}
