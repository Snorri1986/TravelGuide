package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GreeceEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greece_emergency)

        // Ambulance
        val tvNumMedicalGreece = findViewById<TextView>(R.id.tvAmbulanceGreeceNumber)
        tvNumMedicalGreece.setOnClickListener {
            val phoneNum = tvNumMedicalGreece.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Fire brigade
        val tvNumFireGreece = findViewById<TextView>(R.id.tvFireDepGreeceNumber)
        tvNumFireGreece.setOnClickListener {
            val phoneNum = tvNumFireGreece.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Police
        val tvNumPoliceGreece = findViewById<TextView>(R.id.tvPoliceGreeceNumber)
        tvNumPoliceGreece.setOnClickListener {
            val phoneNum = tvNumPoliceGreece.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Coast Guard
        val tvNumCoastGuardGreece = findViewById<TextView>(R.id.tvCoastGuardGreeceNumber)
        tvNumCoastGuardGreece.setOnClickListener {
            val phoneNum = tvNumCoastGuardGreece.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Emergency Social Assistance
        val tvNumSocAssisGreece = findViewById<TextView>(R.id.tvSocAssisGreeceNumber)
        tvNumSocAssisGreece.setOnClickListener {
            val phoneNum = tvNumSocAssisGreece.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
