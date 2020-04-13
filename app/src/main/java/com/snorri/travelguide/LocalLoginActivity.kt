package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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

    }
}
