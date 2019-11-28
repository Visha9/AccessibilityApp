package com.uidemo.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransferTabViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Transfer Tab Fragment"
    }
    val text: LiveData<String> = _text

    private val list_items: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>().apply {

        var list : ArrayList<String> = ArrayList()
        list.add("Account Activity")
        list.add("Gentle Reminder")
        list.add("Notifications")
        list.add("Account Activity")
        list.add("Gentle Reminder")
        list.add("Notifications")
        list.add("Account Activity")
        value = list
    }

    val list : LiveData<ArrayList<String>> = list_items
}