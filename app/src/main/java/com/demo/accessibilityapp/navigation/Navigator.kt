package com.demo.accessibilityapp.navigation

import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.demo.accessibilityapp.R
import com.google.android.material.navigation.NavigationView

class Navigator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var activity: AppCompatActivity

    fun initialSetUp(activity: AppCompatActivity): AppBarConfiguration {
        this.activity = activity
        val drawerLayout: DrawerLayout = activity.findViewById(R.id.drawer_layout)
        val navView: NavigationView = activity.findViewById(R.id.nav_view)
        val navController = activity.findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_transfer, R.id.explore,
                R.id.login, R.id.notifications, R.id.nav_manage,
                R.id.statement, R.id.help
            ), drawerLayout
        )
        activity.setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        return appBarConfiguration
    }

    fun onCreateOptionsMenu(menu: Menu): Boolean {
        activity.menuInflater.inflate(R.menu.main, menu)
        return true
    }

    fun onSupportNavigateUp(): Boolean {
        val navController = activity.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || onSupportNavigateUp()
    }


}