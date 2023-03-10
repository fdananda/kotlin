package com.fdananda.kotlinmvvmbotao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityVM: ViewModel() {

    private val mTexto = MutableLiveData<String>()
    private val mTexto2 = MutableLiveData<String>()
    private val mBotao = MutableLiveData<Boolean>()

    fun enviarTexto(editText1: String, editText2: String) {
        mTexto.value = editText1
        mTexto2.value = editText2
    }

    fun retornarTexto(): LiveData<String>? {
        return mTexto
    }

    fun retornarTexto2(): LiveData<String>? {
        return mTexto2
    }

    fun contarTexto(editText1: String, editText2: String) {
        mBotao.value = false
        if (editText1.length >= 14 && editText2.length >= 6) {
            mBotao.setValue(true)
        } else {
            mBotao.setValue(false)
        }
    }

    fun ativarBotao(): LiveData<Boolean>? {
        return mBotao
    }
}
