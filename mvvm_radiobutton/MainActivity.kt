package com.fdananda.kotlinradiobutton

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2:RadioButton
    private lateinit var radioButton3:RadioButton
    private lateinit var radioButton4:RadioButton
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var textView: TextView
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioButton1 = findViewById(R.id.radioButtonOption1)
        radioButton2 = findViewById(R.id.radioButtonOption2)
        radioButton3 = findViewById(R.id.radioButtonOption3)
        radioButton4 = findViewById(R.id.radioButtonOption4)
        textView = findViewById(R.id.textViewResult)
        radioGroup = findViewById(R.id.radioGroup)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            var optionSelected = ""
            when (checkedId) {
                radioButton1.id -> optionSelected = "1"
                radioButton2.id -> optionSelected = "2"
                radioButton3.id -> optionSelected = "3"
                radioButton4.id -> optionSelected = "4"
            }
            viewModel.onChoice(optionSelected)
        }

        viewModel.getOptionSelected()!!.observe(this
        ) { t ->
            radioButton1.setBackgroundColor(resources.getColor(R.color.background))
            radioButton2.setBackgroundColor(resources.getColor(R.color.background))
            radioButton3.setBackgroundColor(resources.getColor(R.color.background))
            radioButton4.setBackgroundColor(resources.getColor(R.color.background))
            textView.text = "Opção escolhida: $t"
            when (t) {
                "1" -> radioButton1.setBackgroundColor(resources.getColor(R.color.background_selected))
                "2" -> radioButton2.setBackgroundColor(resources.getColor(R.color.background_selected))
                "3" -> radioButton3.setBackgroundColor(resources.getColor(R.color.background_selected))
                "4" -> radioButton4.setBackgroundColor(resources.getColor(R.color.background_selected))
            }
        }
    }
}
