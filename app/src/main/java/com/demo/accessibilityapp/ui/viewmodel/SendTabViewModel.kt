package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendTabViewModel  : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Send Tab Fragment"
    }
    val text: LiveData<String> = _text
}