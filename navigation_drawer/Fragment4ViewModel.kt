package com.fdananda.kotlinnavigationdraweractivity.ui.fragment4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment4ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment 4"
    }
    val text: LiveData<String> = _text
}