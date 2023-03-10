package com.fdananda.kotlinmvvmcomactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val mButton = MutableLiveData<Boolean>()
    private val mType = MutableLiveData<String>()

    fun onText(string: String) {
        if (string.length < 5) {
            mButton.setValue(false)
        } else {
            mButton.setValue(true)
            onDefineType(string)
        }
    }

    private fun onDefineType(string: String) {
        val isInteger = string.matches(Regex("-?\\d+"));
        if (isInteger) {
            mType.setValue("É um número inteiro")
        } else {
            mType.setValue("Não é um número inteiro")
        }
    }

    fun getButtonStatus(): MutableLiveData<Boolean>? {
        return mButton
    }

    fun getResultType(): MutableLiveData<String> {
        return mType
    }
}
