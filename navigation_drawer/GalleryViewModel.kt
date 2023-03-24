package com.fdananda.kotlinnavigationdraweractivity.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment 2"
    }
    val text: LiveData<String> = _text
}