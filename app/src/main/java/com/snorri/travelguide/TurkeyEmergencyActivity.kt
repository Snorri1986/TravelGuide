package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

// v 0.6.11
class TurkeyEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turkey_emergency)

        val notify:String = "Click on number to make call"
        Toast.makeText(this, notify, Toast.LENGTH_LONG).show()

        // Medical/Ambulance.
        val tvNumMedical = findViewById<TextView>(R.id.tvAmbulanceTurkeyNumber)
        tvNumMedical.setOnClickListener {
            val phoneNum = tvNumMedical.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Fire
        val tvNumFire = findViewById<TextView>(R.id.tvFireTurkeyNumber)
        tvNumFire.setOnClickListener {
            val phoneNum = tvNumFire.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Police
        val tvNumPolice = findViewById<TextView>(R.id.tvPoliceTurkeyNumber)
        tvNumPolice.setOnClickListener {
            val phoneNum = tvNumPolice.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Coastguard
        val tvNumCoastGuard = findViewById<TextView>(R.id.tvCoastGuardTurkeyNumber)
        tvNumCoastGuard.setOnClickListener {
            val phoneNum = tvNumCoastGuard.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Forest Fires
        val tvNumForestFires = findViewById<TextView>(R.id.tvForestFiresTurkeyNumber)
        tvNumForestFires.setOnClickListener {
            val phoneNum = tvNumForestFires.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Missing childs
        val tvNumMissingChilds = findViewById<TextView>(R.id.tvMissChildTurkeyNumber)
        tvNumMissingChilds.setOnClickListener {
            val phoneNum = tvNumMissingChilds.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
