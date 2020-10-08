package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SpaineEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spaine_emergency)

        // Fire/Ambulance
        val tvNumMedicalFireSpaine = findViewById<TextView>(R.id.tvMedFireSpaineNumber)
        tvNumMedicalFireSpaine.setOnClickListener {
            val phoneNum = tvNumMedicalFireSpaine.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Local Police
        val tvNumLocalPoliceSpaine = findViewById<TextView>(R.id.tvLocalPoliceSpaineNumber)
        tvNumLocalPoliceSpaine.setOnClickListener {
            val phoneNum = tvNumLocalPoliceSpaine.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Sea Rescue
        val tvNumSeaRescueSpaine = findViewById<TextView>(R.id.tvMaritimaSeaRescueSpaineNumber)
        tvNumSeaRescueSpaine.setOnClickListener {
            val phoneNum = tvNumSeaRescueSpaine.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Red cross
        val tvNumRedCrossSpaine = findViewById<TextView>(R.id.tvRedCrossSpaineNumber)
        tvNumRedCrossSpaine.setOnClickListener {
            val phoneNum = tvNumRedCrossSpaine.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Tourist Help Line
        val tvNumTouristHelpLineSpaine = findViewById<TextView>(R.id.tvTouristHelplineSpaineNumber)
        tvNumTouristHelpLineSpaine.setOnClickListener {
            val phoneNum = tvNumTouristHelpLineSpaine.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
