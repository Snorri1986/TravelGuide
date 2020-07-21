package com.snorri.travelguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

// Activity for choice Taxi services. v 0.6.6.2

class TaxiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxi)

        // onClick methods to icons v 0.6.6.2
        val ivUber = findViewById<ImageView>(R.id.ivUber)
        ivUber.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Uber", Toast.LENGTH_LONG).show()
            // ... //
        }

        val ivUklon = findViewById<ImageView>(R.id.ivUklon)
        ivUklon.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Uklon", Toast.LENGTH_LONG).show()
            // ... //
        }

    }
}
