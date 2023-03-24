package com.fdananda.kotlinnavigationdraweractivity.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment 3"
    }
    val text: LiveData<String> = _text
}