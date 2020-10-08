package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IsraelEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_israel_emergency)

        // Police
        val tvNumPoliceIsrael = findViewById<TextView>(R.id.tvPoliceIsraelNumber)
        tvNumPoliceIsrael.setOnClickListener {
            val phoneNum = tvNumPoliceIsrael.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Ambulance
        val tvNumAmbulanceIsrael = findViewById<TextView>(R.id.tvAmbulanceIsraelNumber)
        tvNumAmbulanceIsrael.setOnClickListener {
            val phoneNum = tvNumAmbulanceIsrael.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Fire Department
        val tvNumFireDepIsrael = findViewById<TextView>(R.id.tvFireDepIsraelNumber)
        tvNumFireDepIsrael.setOnClickListener {
            val phoneNum = tvNumFireDepIsrael.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Electricity company
        val tvNumElectroIsrael = findViewById<TextView>(R.id.tvElectroIsraelNumber)
        tvNumElectroIsrael.setOnClickListener {
            val phoneNum = tvNumElectroIsrael.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

    }
}
