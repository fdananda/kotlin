package com.fdananda.kotlinnavigationdraweractivity.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment 1"
    }
    val text: LiveData<String> = _text
}