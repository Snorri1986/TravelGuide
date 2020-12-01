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

        // Save to DB.
        val btnSave = findViewById<Button>(R.id.btnSaveRegister)
        btnSave.setOnClickListener {
            val dbHandler = UserDBHelper(this, null)
            val user = User(tfLogin.text.toString(),tfPass.text.toString(),tfName.text.toString())
            // check if fields are filled. v1.3
            if (user.Password?.isEmpty()!! || user.Login?.isEmpty()!! || user.userNativeName?.isEmpty()!! ) {
                Toast.makeText(this, tfName.text.toString() + "All fields must be filled ", Toast.LENGTH_LONG).show()
            }
              else {
                dbHandler.addName(user)
                Toast.makeText(
                    this,
                    tfName.text.toString() + " Added to user database",
                    Toast.LENGTH_LONG
                ).show()

                // Go to MainActivity
                val intentbtnReg = Intent(this, MainActivity::class.java)
                startActivity(intentbtnReg)
                // ... //
            }
        }
    }
}
