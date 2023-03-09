package com.fdananda.kotlinviewmodel.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mText: MutableLiveData<String>? = null
    private val mResultado = MutableLiveData<String>()
    private var numero = 0

    fun homeViewModel() {
        mText = MutableLiveData()
        mText!!.value = "Clique no botão abaixo para incrementar"
    }

    fun incrementar() {
        numero++
        mResultado.value = numero.toString()
    }

    fun getText(): LiveData<String>? {
        return mText
    }

    fun getIncremento(): LiveData<String> {
        return mResultado
    }
}
