package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

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

        // Save to DB. Test code 14.04.20202
        val btnSave = findViewById<Button>(R.id.btnSaveRegister)
        btnSave.setOnClickListener {
            val dbHandler = UserDBHelper(this, null)
            val user = User(tfLogin.text.toString(),tfPass.text.toString(),tfName.text.toString())
            dbHandler.addName(user)
            Toast.makeText(this, tfName.text.toString() + " Added to user database", Toast.LENGTH_LONG).show()
        }
        // ... //
    }
}
