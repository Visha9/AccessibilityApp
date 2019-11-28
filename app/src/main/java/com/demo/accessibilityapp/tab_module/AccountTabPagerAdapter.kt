package com.demo.accessibilityapp.tab_module


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class AccountTabPagerAdapter(
    manager: FragmentManager, var arrayOfFragment: Array<Fragment>,
    var arrayOfTitles: Array<String>
) : FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {

        return arrayOfFragment.get(position)

    }

    override fun getCount(): Int {
        return arrayOfFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return arrayOfTitles.get(position)

    }
}