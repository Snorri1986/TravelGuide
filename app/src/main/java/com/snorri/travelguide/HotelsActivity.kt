package com.snorri.travelguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

// Activity for choice Hotel services. v 0.6.6.2

class HotelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)


        // onClick methods to icons  v 0.6.6.2
        val ivBooking = findViewById<ImageView>(R.id.ivBookingCom)
        ivBooking.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Booking.com", Toast.LENGTH_LONG).show()
            // ... //
        }

        val ivAirBnB = findViewById<ImageView>(R.id.ivAirBnbRu)
        ivAirBnB.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Airbnb.ru", Toast.LENGTH_LONG).show()
            // ... //
        }

        val ivTrivago = findViewById<ImageView>(R.id.ivTrivagoCom)
        ivTrivago.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Trivago.com", Toast.LENGTH_LONG).show()
            // ... //
        }

        val ivAgoda = findViewById<ImageView>(R.id.ivAgodaCom)
        ivAgoda.setOnClickListener {
            // temp
            Toast.makeText(this, "User choice Agoda.com", Toast.LENGTH_LONG).show()
            // ... //
        }
        // ... //
    }
}
