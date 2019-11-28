package com.uidemo.ui.fragment.account_tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.accessibilityapp.R
import com.demo.accessibilityapp.list_module.RecyclerList

import com.uidemo.ui.viewmodel.TransferTabViewModel

class TransferTabFragment : Fragment() {

    private lateinit var transferTabViewModel: TransferTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        transferTabViewModel = ViewModelProviders.of(this).get(TransferTabViewModel::class.java)

        val root = inflater.inflate(R.layout.tab_fragment_transfer, container, false)
        transferTabViewModel

        transferTabViewModel.list.observe(this, Observer {

            RecyclerList(requireActivity(), root).createListWithArray(it)
        })

        return root
    }
}