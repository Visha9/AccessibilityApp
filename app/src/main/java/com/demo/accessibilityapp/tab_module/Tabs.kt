package com.demo.accessibilityapp.tab_module

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.demo.accessibilityapp.R
import com.google.android.material.tabs.TabLayout


class Tabs(var childFragmentManager: FragmentManager) {

    private lateinit var tabs_main: TabLayout

    fun setUpTabs(
        view: View,
        tabs: Array<Fragment>,
        tabsTitles: Array<String>, tabIcons: Array<Int>
    ) {


        val viewpager_main = view.findViewById<ViewPager>(R.id.viewpager)
        tabs_main = view.findViewById<TabLayout>(R.id.tabs)

        val adapter = AccountTabPagerAdapter(
            childFragmentManager,
            tabs,
            tabsTitles
        )
        viewpager_main.setAdapter(adapter)
        tabs_main.setupWithViewPager(viewpager_main)
        viewpager_main.setOffscreenPageLimit(0)
        setupTabIcons(tabIcons)
    }


    fun setupTabIcons(tabIcons: Array<Int>) {

        for (index in 0..tabIcons.size) {
            tabs_main.getTabAt(index)?.setIcon(tabIcons[index])
        }
    }


}