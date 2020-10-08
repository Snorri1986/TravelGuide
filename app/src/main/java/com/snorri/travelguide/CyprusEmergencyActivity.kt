package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CyprusEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cyprus_emergency)

        // Ambulance
        val tvNumMedical = findViewById<TextView>(R.id.tvAmbulanceCyprusNumber)
        tvNumMedical.setOnClickListener {
            val phoneNum = tvNumMedical.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Fire Department
        val tvNumFireDep = findViewById<TextView>(R.id.tvFireDepCyprusNumber)
        tvNumFireDep.setOnClickListener {
            val phoneNum = tvNumFireDep.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Police
        val tvNumPoliceCyprus = findViewById<TextView>(R.id.tvPoliceCyprusNumber)
        tvNumPoliceCyprus.setOnClickListener {
            val phoneNum = tvNumPoliceCyprus.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Forest Fire
        val tvNumForestFireCyprus = findViewById<TextView>(R.id.tvForestFireCyprusNumber)
        tvNumForestFireCyprus.setOnClickListener {
            val phoneNum = tvNumForestFireCyprus.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Narcotics Emergency
        val tvNumDrugsCyprus = findViewById<TextView>(R.id.tvDrugsCyprusNumber)
        tvNumDrugsCyprus.setOnClickListener {
            val phoneNum = tvNumDrugsCyprus.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
