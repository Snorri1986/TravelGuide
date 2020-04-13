package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Back to the MainActivity
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            val intentbtnCancel = Intent(this, MainActivity::class.java)
            startActivity(intentbtnCancel)
        }

    }
}
