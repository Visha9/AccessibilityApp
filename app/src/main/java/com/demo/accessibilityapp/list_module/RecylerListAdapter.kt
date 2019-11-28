package com.demo.accessibilityapp.list_module

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.accessibilityapp.R

class RecylerListAdapter(val items: ArrayList<String>, val context: Activity?) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvAnimalType?.text = items.get(position)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvAnimalType = view.findViewById<TextView>(R.id.text_title_listitem)
}