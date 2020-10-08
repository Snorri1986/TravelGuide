package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UAEEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_a_e_emergency)

        // Police
        val tvNumPoliceUAE = findViewById<TextView>(R.id.tvPoliceUAENumber)
        tvNumPoliceUAE.setOnClickListener {
            val phoneNum = tvNumPoliceUAE.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Ambulance
        val tvNumAmbulanceUAE = findViewById<TextView>(R.id.tvAmbulanceUAENumber)
        tvNumAmbulanceUAE.setOnClickListener {
            val phoneNum = tvNumAmbulanceUAE.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Fire Department
        val tvNumFireUAE = findViewById<TextView>(R.id.tvFireUAENumber)
        tvNumFireUAE.setOnClickListener {
            val phoneNum = tvNumFireUAE.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Coast Guard
        val tvNumCoastGuardUAE = findViewById<TextView>(R.id.tvCoastGuardUAENumber)
        tvNumCoastGuardUAE.setOnClickListener {
            val phoneNum = tvNumCoastGuardUAE.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Electricity failure
        val tvNumElectroUAE = findViewById<TextView>(R.id.tvElectroUAENumber)
        tvNumElectroUAE.setOnClickListener {
            val phoneNum = tvNumElectroUAE.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Water emergency
        val tvNumWaterUAE = findViewById<TextView>(R.id.tvWaterUAENumber)
        tvNumWaterUAE.setOnClickListener {
            val phoneNum = tvNumWaterUAE.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
