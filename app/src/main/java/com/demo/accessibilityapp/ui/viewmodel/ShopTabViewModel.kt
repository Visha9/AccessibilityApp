package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopTabViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Shop Tab Fragment"
    }
    val text: LiveData<String> = _text
}