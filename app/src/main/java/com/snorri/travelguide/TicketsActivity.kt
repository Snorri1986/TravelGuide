package com.snorri.travelguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

// Activity for choice Tickets services.  v 0.6.6.2

class TicketsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickets)

        // onClick methods to icons v 0.6.6.2
        val ivGoBibi = findViewById<ImageView>(R.id.ivGoibibi)
        ivGoBibi.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Goibibi.com", Toast.LENGTH_LONG).show()
            // ... //
        }

        val ivMakeMyTrip = findViewById<ImageView>(R.id.ivMakeMyTrip)
        ivMakeMyTrip.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice MakeMyTrip.com", Toast.LENGTH_LONG).show()
            // ... //
        }

        val ivSkyScanner = findViewById<ImageView>(R.id.ivSkyScanner)
        ivSkyScanner.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice SkyScanner.com", Toast.LENGTH_LONG).show()
            // ... //
        }

    }
}
