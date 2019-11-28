package com.demo.accessibilityapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Account Fragment"
    }
    val text: LiveData<String> = _text

    private val list_items: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>().apply {

        var list : ArrayList<String> = ArrayList()
        list.add("Account Activity")
        list.add(" Reminder")
        list.add("Notifications")
        list.add(" Activity")
        list.add("Gentle ")
        list.add("Notifications")
        list.add("Account Activity")
        value = list
    }

    val list : LiveData<ArrayList<String>> = list_items
}