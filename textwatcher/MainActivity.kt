package com.fdananda.kotlintextwatcher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var editText: TextInputEditText
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText_text)
        textView = findViewById(R.id.textView_Text)
        textView.text = "O texto que você digitar, aparecerá aqui"

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length > 0) {
                    textView.text = editText.text.toString()
                } else {
                    textView.text = "O texto que você digitar, aparecerá aqui.\nTente de novo!"
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

    }
}
