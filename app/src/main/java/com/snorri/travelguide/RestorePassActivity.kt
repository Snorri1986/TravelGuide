package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_restore_pass.*


class RestorePassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_pass)

        // show password. v1.3
        val btnShowPass = findViewById<Button>(R.id.btnShowPassword)
        btnShowPass.setOnClickListener {
            // get UserDBHelper instance
            val dbHandler = UserDBHelper(this, null)
            // get UsrNativeName
            val UsrNatName = tfNameRestorePass.text.toString()
            // get Pass
            val authUser = dbHandler.getPasswordByUsrName(UsrNatName)
            // show pass in Toast
            if (authUser != null) {
                Toast.makeText(this, "Your password is " + authUser.Password.toString(), Toast.LENGTH_LONG).show()
            }
            // Redirect to LocalLoginActivity v 1.3
            // after delayMillis (4 sec now)
            Handler().postDelayed(Runnable {
                val intentbtnLocalLogIN = Intent(this, LocalLoginActivity::class.java)
                startActivity(intentbtnLocalLogIN)
            },4000)
            // ... //
        }
        // ... //
    }
}
