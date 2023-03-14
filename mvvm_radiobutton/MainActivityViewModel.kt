package com.fdananda.kotlinradiobutton

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val mOptionSelected = MutableLiveData<String>()

    fun onChoice(optionSelected: String?) {
        when (optionSelected) {
            "1" -> mOptionSelected.setValue("1")
            "2" -> mOptionSelected.setValue("2")
            "3" -> mOptionSelected.setValue("3")
            "4" -> mOptionSelected.setValue("4")
        }
    }

    fun getOptionSelected(): MutableLiveData<String> {
        return mOptionSelected
    }
}
