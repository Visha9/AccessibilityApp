package com.demo.accessibilityapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.demo.accessibilityapp.navigation.Navigator

open class BaseActivity: AppCompatActivity() {
    var actType : Int = 0;
    var navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun setActivityType(type : Int) {
        actType = type
        when (type) {
            Constants().NAVIGATION_TYPE -> {
                (navigator).initialSetUp(this)
            }
            else -> {
                print("x is neither 1 nor 2")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        when (actType){
            Constants().NAVIGATION_TYPE -> {
                navigator.onCreateOptionsMenu(menu)
            }
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        when (actType){
            Constants().NAVIGATION_TYPE -> {
                var isNavigate : Boolean =  navigator.onSupportNavigateUp()
                return isNavigate
            }
        }
        return false
    }

    fun setHeaderTitle(title : String){
        supportActionBar?.title=title
    }









}