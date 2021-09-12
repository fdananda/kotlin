package com.fdananda.gitkotlinforinarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val posts = arrayOf(
                "Post 1",
                "Post 2",
                "Post 3",
                "Post 4",
                "Post 5"
        )

        var text = ""
        for(post in posts ){
            text += "\n$post"
            textView.text = text
            Log.d("posts", "Post: $post")
        }
    }
}
