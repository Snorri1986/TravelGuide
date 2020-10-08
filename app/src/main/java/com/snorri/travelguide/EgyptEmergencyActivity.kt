package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class EgyptEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eqypt_emergency)

        val notify:String = "Click on number to make call"
        Toast.makeText(this, notify, Toast.LENGTH_LONG).show()

        // Ambulance
        val tvNumMedical = findViewById<TextView>(R.id.tvAmbulanceEgyptNumber)
        tvNumMedical.setOnClickListener {
            val phoneNum = tvNumMedical.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Fire Department
        val tvNumFireDep = findViewById<TextView>(R.id.tvFireDepEgyptNumber)
        tvNumFireDep.setOnClickListener {
            val phoneNum = tvNumFireDep.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Tourist Police
        val tvNumTourPolice = findViewById<TextView>(R.id.tvTouristPoliceEgyptNumber)
        tvNumTourPolice.setOnClickListener {
            val phoneNum = tvNumTourPolice.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Traffic Police
        val tvNumTraffPolice = findViewById<TextView>(R.id.tvTrafficPoliceEgyptNumber)
        tvNumTraffPolice.setOnClickListener {
            val phoneNum = tvNumTraffPolice.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Emergency Police
        val tvNumEmergPolice = findViewById<TextView>(R.id.tvEmergencyPoliceNumberEgypt)
        tvNumEmergPolice.setOnClickListener {
            val phoneNum = tvNumEmergPolice.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Electricity Emergency
        val tvNumElectricity = findViewById<TextView>(R.id.tvElectricityEgyptNumber)
        tvNumElectricity.setOnClickListener {
            val phoneNum = tvNumElectricity.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Natural Gas Emergency
        val tvNumGas = findViewById<TextView>(R.id.tvGasEgyptNumber)
        tvNumGas.setOnClickListener {
            val phoneNum = tvNumGas.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
