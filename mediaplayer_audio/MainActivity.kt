package com.fdananda.kotlinmediaplayeraudio

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var mediaPlayerAudio: MediaPlayer? = null
    private var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayerAudio = MediaPlayer.create(getApplicationContext(), R.raw.musica)
        controlarVolume()
    }

    private fun controlarVolume() {
        val seekBarVolume: SeekBar = findViewById(R.id.seekBarVolume)
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val volMax = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val volAtual = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
        seekBarVolume.setMax(volMax)
        seekBarVolume.setProgress(volAtual)
        seekBarVolume.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                audioManager!!.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    progress,
                    AudioManager.FLAG_SHOW_UI
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    fun play(view: View?) {
        if (mediaPlayerAudio != null) {
            mediaPlayerAudio!!.start()
        }
    }

    fun pause(view: View?) {
        if (mediaPlayerAudio!!.isPlaying) {
            mediaPlayerAudio!!.pause()
        }
    }

    fun stop(view: View?) {
        if (mediaPlayerAudio!!.isPlaying) {
            mediaPlayerAudio!!.stop()
            mediaPlayerAudio = MediaPlayer.create(applicationContext, R.raw.musica)
        }
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayerAudio!!.isPlaying) {
            mediaPlayerAudio!!.pause()
        }
    }

    override fun onRestart() {
        super.onRestart()
        if (!mediaPlayerAudio!!.isPlaying) {
            mediaPlayerAudio!!.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayerAudio != null && mediaPlayerAudio!!.isPlaying()) {
            mediaPlayerAudio!!.stop()
            mediaPlayerAudio!!.release()
            mediaPlayerAudio = null
        }
    }
}
