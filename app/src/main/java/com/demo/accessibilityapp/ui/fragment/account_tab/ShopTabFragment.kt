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

import com.uidemo.ui.viewmodel.ShopTabViewModel

class ShopTabFragment : Fragment() {

    private lateinit var shopTabViewModel : ShopTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        shopTabViewModel = ViewModelProviders.of(this).get(ShopTabViewModel::class.java)

        val root = inflater.inflate(R.layout.tab_fragment_shop, container, false)
        shopTabViewModel.text.observe(this, Observer {
            //Toast.makeText(activity,it, Toast.LENGTH_LONG).show()
        })
        return root
    }
}