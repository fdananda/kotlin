package com.fdananda.gitkotlincomponentesinterface

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textInputEditText: TextInputEditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var toggleButton: ToggleButton
    private lateinit var switch1: Switch
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var textView: TextView
    private lateinit var itensCapturados: String
    private lateinit var textoRadioGroup: String
    private lateinit var textoToggleButton: String
    private lateinit var textoSwitch: String
    private lateinit var textoCheckbox1: String
    private lateinit var textoCheckbox2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText            = findViewById(R.id.editText)
        textInputEditText   = findViewById(R.id.textInputEditText)
        radioGroup          = findViewById(R.id.radioGroup)
        radioButton1        = findViewById(R.id.radioButton1)
        radioButton2        = findViewById(R.id.radioButton2)
        toggleButton        = findViewById(R.id.toggleButton)
        switch1             = findViewById(R.id.switch1)
        checkBox1           = findViewById(R.id.checkBox1)
        checkBox2           = findViewById(R.id.checkBox2)
        textView            = findViewById(R.id.textView2)

        listenerButton1()
        listenerButton2()
        listenerToggle()
        listenerSwitch()
        listenerCheckbox1()
        listenerCheckbox2()
    }

    fun listenerButton1() {
        radioButton1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (radioButton1.isChecked) {
                Toast.makeText(
                    this@MainActivity,
                    "RadioButton1 foi selecionado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun listenerButton2() {
        radioButton2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (radioButton2.isChecked) {
                Toast.makeText(
                    this@MainActivity,
                    "RadioButton2 foi selecionado",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun listenerToggle() {
        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (toggleButton.isChecked) {
                Toast.makeText(this@MainActivity, "Toogle foi ligado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Toogle foi desligado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun listenerSwitch() {
        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (switch1.isChecked) {
                Toast.makeText(this@MainActivity, "Switch foi ligado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Switch foi desligado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun listenerCheckbox1() {
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (checkBox1.isChecked) {
                Toast.makeText(this@MainActivity, "Checkbox1 foi marcado", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this@MainActivity, "Checkbox1 foi desmarcado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun listenerCheckbox2() {
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (checkBox2.isChecked) {
                Toast.makeText(this@MainActivity, "Checkbox2 foi marcado", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this@MainActivity, "Checkbox2 foi desmarcado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun capturarDados(view: View) {

        //Seleção RadioGroup
        textoRadioGroup = if (radioButton1.isChecked) {
            "RadioButton1"
        } else if (radioButton2.isChecked) {
            "RadioButton2"
        } else {
            "Nenhum radioButton selecionado!"
        }

        //Seleção toggleButtorn
        textoToggleButton = if (toggleButton.isChecked) {
            "Ligado"
        } else {
            "Desligado"
        }

        //Seleção switch
        textoSwitch = if (switch1.isChecked) {
            "Ligado"
        } else {
            "Desligado"
        }

        //Seleção checkbox1
        textoCheckbox1 = if (checkBox1.isChecked) {
            "Selecionado"
        } else {
            "Não selecionado"
        }

        //Seleção checkbox2
        textoCheckbox2 = if (checkBox2.isChecked) {
            "Selecionado"
        } else {
            "Não selecionado"
        }
        itensCapturados = "EditText: " + editText.text.toString()
        itensCapturados = "$itensCapturados\nTextInputEditText: ${textInputEditText.text.toString()}"
        itensCapturados = "$itensCapturados\nRadioGroup: $textoRadioGroup"
        itensCapturados = "$itensCapturados\nToggleButton: $textoToggleButton"
        itensCapturados = "$itensCapturados\nSwitch: $textoSwitch"
        itensCapturados = "$itensCapturados\nCheckBox1: $textoCheckbox1"
        itensCapturados = "$itensCapturados\nCheckBox2: $textoCheckbox2"
        textView.text = itensCapturados
    }
}
