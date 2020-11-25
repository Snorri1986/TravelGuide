package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import bolts.Task.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Check Android version before use app. Must be higher then Android 6.0  v 1.1

        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.M) {

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
            val btnCallFacebook = findViewById<Button>(R.id.btnFacebookAuth)
            btnCallFacebook.setOnClickListener {
                val intentCallFacebookAuth = Intent(this, FacebookAuthActivity::class.java)
                startActivity(intentCallFacebookAuth)
            }
        } else {
            // user notification. v 1.1
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            Toast.makeText(this, "You Android OS Version doesn't support", Toast.LENGTH_LONG).show()
            // close app in 4 seconds. v 1.1
            Handler().postDelayed(Runnable {
                closeApp()
            },4000)
        }
    }

    // close application v 1.1
    fun closeApp() {
        finish()
        exitProcess(0)
            }
    }



