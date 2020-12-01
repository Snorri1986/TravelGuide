package com.snorri.travelguide

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_local_login.*

class LocalLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_login)

        // Back to the MainActivity
        val btnCancelLocal = findViewById<Button>(R.id.btnCancelLocal)
        btnCancelLocal.setOnClickListener {
            val intentbtnCancelLocal = Intent(this, MainActivity::class.java)
            startActivity(intentbtnCancelLocal)
        }

        // Restore password activity. v1.3
        val btnRestorePass = findViewById<Button>(R.id.btnRestorePassword)
        btnRestorePass.setOnClickListener {
            val intentbtnRestorePass = Intent(this, RestorePassActivity::class.java)
            startActivity(intentbtnRestorePass)
        }
        // ... //


        // GO Button
        val btnGobutton = findViewById<Button>(R.id.btnGo)
        btnGobutton.setOnClickListener {
            // get user input
            val dbHandler = UserDBHelper(this, null)
            val etLogin = tfLoginLocal.text.toString()
            val etPassword = tfPassLocal.text.toString()

            // call database method
            val authUser = dbHandler.getUser(etLogin)

            // check username and password and go to next activity
            if(authUser?.Login == etLogin && authUser?.Password == etPassword) {
                val intentGoNext = Intent(this, WorkActivity::class.java)
                intentGoNext.putExtra("UserNativeName",authUser?.userNativeName)
                intentGoNext.putExtra("UserLogin",authUser?.Login)
                // Get user image from DB
                val profileImage = dbHandler.getUserImage(etLogin)
                // Pass it to WorkAcrivity
                intentGoNext.putExtra("UsrImage",profileImage)
                // ... //
                startActivity(intentGoNext)
                // Activate Geolocation message
                Toast.makeText(this, "Click back once to activation Geolocation", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show()
            }
            // ... //
        }
    }
}
