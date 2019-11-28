package com.demo.accessibilityapp.ui.fragment


import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.accessibilityapp.BaseActivity
import com.demo.accessibilityapp.Constants
import com.demo.accessibilityapp.R
import com.demo.accessibilityapp.list_module.RecyclerList
import com.demo.accessibilityapp.tab_module.Tabs
import com.demo.accessibilityapp.ui.viewmodel.AccountViewModel
import com.google.android.material.tabs.TabLayout


class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        (activity as BaseActivity).setHeaderTitle(requireActivity().getString(R.string.title_account))


        val root = inflater.inflate(R.layout.fragment_account, container, false)
        accountViewModel.list.observe(
            this,
            Observer { RecyclerList(requireActivity(), root).createListWithArray(it) })




        Tabs(childFragmentManager).setUpTabs(
            root,
            Constants().tab_fragments,
            resources.getStringArray(R.array.tab_items),
            Constants().tab_icons
        )

        return root
    }


}