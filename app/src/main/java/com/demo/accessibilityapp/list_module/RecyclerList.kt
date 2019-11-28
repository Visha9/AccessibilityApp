package com.demo.accessibilityapp.list_module

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.accessibilityapp.R

class RecyclerList (var activity: Activity, var root : View){

    lateinit var list : RecyclerView

    fun createListWithArray(array : ArrayList<String>){
        list = root.findViewById<RecyclerView>(R.id.list)
        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = RecylerListAdapter(array, activity)
    }
}