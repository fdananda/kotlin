package com.fdananda.kotlindataatual

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var textViewDataAtual: TextView
    private lateinit var textViewHoraAtual:TextView
    private lateinit var textViewDetalhesDataHora:TextView
    private lateinit var editTextQtdDias: EditText
    private lateinit var editTextDataInicial:EditText
    private lateinit var editTextDataFinal:EditText
    private lateinit var switchType: Switch
    private lateinit var textViewResultado: TextView
    private lateinit var textViewResultado2:TextView
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewDataAtual        = findViewById(R.id.textViewTextoData)
        textViewHoraAtual        = findViewById(R.id.textViewTextoHora)
        textViewDetalhesDataHora = findViewById(R.id.textViewDetalhesDataHora)

        editTextQtdDias          = findViewById(R.id.editTextQuant)
        switchType               = findViewById(R.id.switch1)
        textViewResultado        = findViewById(R.id.textViewResultado)

        editTextDataInicial      = findViewById(R.id.editText_data1)
        editTextDataFinal        = findViewById(R.id.editText_data2)
        textViewResultado2       = findViewById(R.id.textViewResultado2)

        //Incluir máscaras nas datas
        editTextDataInicial.addTextChangedListener(mask(editTextDataInicial))
        editTextDataFinal.addTextChangedListener(mask(editTextDataFinal))

        data = Data()
    }

    fun obterDataAtual(view: View?) {
        textViewDataAtual.setText(data.getDataAtual())
    }

    fun obterHoraAtual(view: View?) {
        textViewHoraAtual.setText(data.getHoraAtual())
    }

    fun obterDetalhesDataHora(view: View?) {
        textViewDetalhesDataHora.setText(data.getDetalhesDataHora())
    }

    fun calcularDatas(view: View?) {
        if (editTextQtdDias.text.toString() != "" || !editTextQtdDias.text.toString().isEmpty()) {
            val dataAtual = System.currentTimeMillis()
            val novaData = Date(dataAtual)
            val type: Boolean
            type = switchType.isChecked
            Log.d("type", type.toString())
            if (!type) {
                novaData.setDate(novaData.getDate() - editTextQtdDias.text.toString().toInt())
            } else {
                novaData.setDate(novaData.getDate() + editTextQtdDias.text.toString().toInt())
            }
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            val dataResultado: String = simpleDateFormat.format(novaData)
            textViewResultado.text = dataResultado
        } else {
            textViewResultado.text = ""
            Toast.makeText(this, "Preencha a quantidade de dias!", Toast.LENGTH_SHORT).show()
        }
    }

    fun calcularDias(view: View?) {
        if ((editTextDataInicial.text.toString() != "" || !editTextDataInicial.text
                .toString().isEmpty()) && (editTextDataFinal.text.toString() != "" ||
                    !editTextDataFinal.text.toString().isEmpty())
        ) {
            val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")
            dateFormat.setLenient(false)
            var dateOk: Boolean
            try {
                dateFormat.parse(editTextDataInicial.text.toString())
                dateOk = true
            } catch (ex: ParseException) {
                dateOk = false
                Toast.makeText(this, "Data inicial inválida", Toast.LENGTH_SHORT).show()
            }
            if (dateOk) {
                try {
                    dateFormat.parse(editTextDataFinal.text.toString())
                    dateOk = true
                } catch (ex: ParseException) {
                    dateOk = false
                    Toast.makeText(this, "Data final inválida", Toast.LENGTH_SHORT).show()
                }
            }
            if (dateOk) {
                try {
                    val dataInicial: Date = dateFormat.parse(editTextDataInicial.text.toString())
                    val dataFinal: Date = dateFormat.parse(editTextDataFinal.text.toString())
                    if (dataFinal.getTime() > dataInicial.getTime()) {
                        val qtdDias: Long = dataFinal.getTime() - dataInicial.getTime() + 3600000
                        textViewResultado2.text = (qtdDias / 86400000L).toString() + " dias"
                    } else {
                        textViewResultado2.text = ""
                        Toast.makeText(
                            this,
                            "Data Inicial maior do que Data Final. Favor corrigir",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        } else {
            Toast.makeText(this, "Campo(s) não preenchido(s)", Toast.LENGTH_SHORT).show()
        }
    }

    fun mask(editText: EditText): TextWatcher? {
        return object : TextWatcher {
            var isUpdating = false
            var old = ""
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val str = unmask(s.toString())
                var mascara = ""
                if (isUpdating) {
                    old = str
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in "##/##/####".toCharArray()) {
                    if (m != '#' && str.length > old.length) {
                        mascara += m
                        continue
                    }
                    mascara += try {
                        str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }
                isUpdating = true
                editText.setText(mascara)
                editText.setSelection(mascara.length)
            }

            fun unmask(s: String): String {
                return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
                    .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
                    .replace("[ ]".toRegex(), "").replace("[:]".toRegex(), "")
                    .replace("[)]".toRegex(), "")
            }
        }
    }
}
