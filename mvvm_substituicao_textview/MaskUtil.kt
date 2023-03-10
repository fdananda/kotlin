package com.fdananda.kotlinmvvmbotao

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText

open class MaskUtil {

    private val maskCPF = "###.###.###-##"

    open fun unmask(s: String): String {
        return s.replace("[^0-9]*".toRegex(), "")
    }

    open fun insert(editText: EditText): TextWatcher? {
        return object : TextWatcher {
            var isUpdating = false
            var old = ""
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var maskUtil = MaskUtil()
                val str: String = maskUtil.unmask(s.toString())
                val mask: String
                mask = maskCPF
                var mascara = ""
                if (isUpdating) {
                    old = str
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && str.length > old.length || m != '#' && str.length < old.length && str.length != i) {
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
                Log.i("Resultado: ", "Texto com máscara: $s")
                val cpfSemMascara = s.toString().replace("[^0-9]*".toRegex(), "")
                Log.i("Resultado", "Texto sem máscara: $cpfSemMascara")
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        }
    }
}
