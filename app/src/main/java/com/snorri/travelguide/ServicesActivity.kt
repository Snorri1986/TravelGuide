package com.snorri.travelguide


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import java.util.*


class ServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_travel)

        // Taxi button. ready to commit v.0.6.6.2
        val btnTaxi = findViewById<Button>(R.id.btnTaxxis)
        btnTaxi.setOnClickListener {
            val intentbtnTaxi = Intent(this, TaxiActivity::class.java)
            startActivity(intentbtnTaxi)
        }
        // ... //

        // Hotels button. ready to commit v.0.6.6.2
        val btnHotels = findViewById<Button>(R.id.btnAcomHotels)
        btnHotels.setOnClickListener {
            val intentbtnHotels = Intent(this, HotelsActivity::class.java)
            startActivity(intentbtnHotels)
        }
        // ... //

        // Tickets button. ready to commit v.0.6.6.2
        val btnTickets = findViewById<Button>(R.id.btnTransportPass)
        btnTickets.setOnClickListener {
            val intentbtnTickets = Intent(this, TicketsActivity::class.java)
            startActivity(intentbtnTickets)
        }
        // ... //

        // reminder v.0.6.9
        val btnReminder = findViewById<Button>(R.id.btnReminder)
        btnReminder.setOnClickListener {
            val cal = Calendar.getInstance()
            val intent = Intent(Intent.ACTION_EDIT)
            intent.type = "vnd.android.cursor.item/event"
            intent.putExtra("beginTime", cal.timeInMillis)
            intent.putExtra("allDay", false)
            intent.putExtra("rrule", "FREQ=DAILY")
            intent.putExtra("endTime", cal.timeInMillis + 60 * 60 * 1000)
            intent.putExtra("title", "Name of trip")
            startActivity(intent)
        }
        // ... //


        // Emergency. Ready to commit v 0.6.11
        val btnEmerg = findViewById<Button>(R.id.btnEmergency)
        btnEmerg.setOnClickListener {
            val intentbtnEmerg = Intent(this, EmergencyActivity::class.java)
            startActivity(intentbtnEmerg)
        }
        // ... //
    }
}




