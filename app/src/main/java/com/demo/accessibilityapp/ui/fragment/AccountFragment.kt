package com.demo.accessibilityapp.ui.fragment


import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.accessibilityapp.BaseActivity
import com.demo.accessibilityapp.Constants
import com.demo.accessibilityapp.R
import com.demo.accessibilityapp.list_module.RecyclerList
import com.demo.accessibilityapp.tab_module.Tabs
import com.demo.accessibilityapp.ui.viewmodel.AccountViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
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
        var topLL=root.findViewById<LinearLayout>(R.id.topLL)
        var text_title_bottom_sheet=root.findViewById<TextView>(R.id.text_title_bottom_sheet)

        var bottomSheetBehavior = BottomSheetBehavior.from(topLL)

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            text_title_bottom_sheet.announceForAccessibility("Bottom Sheet Opened")
                            text_title_bottom_sheet.isFocusable = true
                            text_title_bottom_sheet.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES

                        }

                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
            }
        })



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