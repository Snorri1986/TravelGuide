package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AustraliaEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_australia_emergency)

        // Police/Fire/Ambulance
        val tvNumMedicalAustarlia = findViewById<TextView>(R.id.tvPFAAustraliaNumber)
        tvNumMedicalAustarlia.setOnClickListener {
            val phoneNum = tvNumMedicalAustarlia.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // SES assistance
        val tvSESAustralia = findViewById<TextView>(R.id.tvSESAustraliaNumber)
        tvSESAustralia.setOnClickListener {
            val phoneNum = tvSESAustralia.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Emergency helpline
        val tvEmergHelpLineAustralia = findViewById<TextView>(R.id.tvEmergencyHelpLineAustraliaNumber)
        tvEmergHelpLineAustralia.setOnClickListener {
            val phoneNum = tvEmergHelpLineAustralia.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //
    }
}
