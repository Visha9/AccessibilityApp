package com.demo.accessibilityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (supportActionBar != null)
            supportActionBar?.hide()

        var btnLoginHelp = findViewById<TextView>(R.id.text_login_help)
        var buttonLogin = findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener(this)
        btnLoginHelp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLogin -> {
                goToMainActivity()
            }
            R.id.text_login_help -> {
                showNewNameDialog()
            }
            R.id.btnForgetPassword -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.forgot_username),
                    Toast.LENGTH_SHORT
                ).show()
            }
            R.id.btnResetPassword->{
                Toast.makeText(
                    applicationContext,
                    getString(R.string.reset_password),
                    Toast.LENGTH_SHORT
                ).show()
            }
            }

    }

    fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun showNewNameDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.login_help_dialog, null)
        dialogBuilder.setCancelable(true)
        dialogBuilder.setView(dialogView)
        val b = dialogBuilder.create()

        val btnForgetPassword = dialogView.findViewById(R.id.btnForgetPassword) as Button
        val btnResetPassword = dialogView.findViewById(R.id.btnResetPassword) as Button
        var btnCancel = dialogView.findViewById(R.id.btnCancel) as Button


        btnForgetPassword.setOnClickListener(this)
        btnResetPassword.setOnClickListener (this)
        btnCancel.setOnClickListener { dialogView ->
            Toast.makeText(applicationContext, getString(R.string.cancel), Toast.LENGTH_SHORT)
                .show()
            b.dismiss()
        }


        b.show()
    }
}
