package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.snorri.travelguide.UserDBHelper.Companion.TABLE_NAME
import kotlinx.android.synthetic.main.activity_local_login.*
import kotlinx.android.synthetic.main.activity_register.*

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
                startActivity(intentGoNext)
            } else {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}
