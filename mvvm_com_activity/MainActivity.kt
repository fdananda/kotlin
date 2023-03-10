package com.fdananda.kotlinmvvmcomactivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var mTextView: TextView? = null
    private var mButton: Button? = null
    private var viewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditText: EditText = findViewById(R.id.editTextText)
        mTextView = findViewById(R.id.textView)
        mButton = findViewById(R.id.button)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (!mEditText.getText().toString().isEmpty()) {
                    viewModel!!.onText(mEditText.getText().toString())
                    mTextView!!.setText("")
                }
            }
            override fun afterTextChanged(s: Editable) {}
        })

        viewModel!!.getButtonStatus()!!.observe(this, object : Observer<Boolean?> {
            override fun onChanged(aBoolean: Boolean?) {
                mButton!!.setEnabled(aBoolean!!)
            }
        })
        mButton!!.setOnClickListener{ getResult() }
    }

    private fun getResult() {
        viewModel!!.getResultType().observe(this, object : Observer<String?> {
            override fun onChanged(s: String?) {
                mTextView!!.text = s
            }
        })
    }
}
