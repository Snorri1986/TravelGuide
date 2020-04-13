package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register button --> RegisterActivity
        val btnRegist = findViewById<Button>(R.id.Register)
        btnRegist.setOnClickListener {
            val intentbtnRegist = Intent(this, RegisterActivity::class.java)
            startActivity(intentbtnRegist)
        }

        // Log In button --> LocalLoginActivity
        val btnLocalLogIN = findViewById<Button>(R.id.btnLogin)
        btnLocalLogIN.setOnClickListener {
            val intentbtnLocalLogIN = Intent(this, LocalLoginActivity::class.java)
            startActivity(intentbtnLocalLogIN)
        }

        // Facebook button ---> To facebook API
        // TODO: call Facebook API

    }
}
