package com.fdananda.kotlininputmethodmanager

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonHideKeyboard: Button
    lateinit var buttonShowKeyBoard:Button
    private lateinit var editText: EditText
    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHideKeyboard = findViewById(R.id.button_hideKeyboard)
        buttonShowKeyBoard = findViewById(R.id.button_showKeyboard)
        buttonShowKeyBoard.visibility = View.INVISIBLE
        editText = findViewById(R.id.editText)
        inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                buttonShowKeyBoard.visibility = View.VISIBLE
            }
        })
    }

    fun hideKeyboard(v: View) {
        inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
    }

    fun showKeyboard(v: View){
        inputMethodManager.showSoftInput(editText, 0)
    }
}
