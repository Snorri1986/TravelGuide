package com.snorri.travelguide

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UKEmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_k_emergency)

        // Ambulance/Fire/Police
        val tvNumMedFirePoliceUK = findViewById<TextView>(R.id.tvMedFirePoliceUKNumber)
        tvNumMedFirePoliceUK.setOnClickListener {
            val phoneNum = tvNumMedFirePoliceUK.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // Gas
        val tvGasUK = findViewById<TextView>(R.id.tvGasEmergencyUKNumber)
        tvGasUK.setOnClickListener {
            val phoneNum = tvGasUK.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        // ... //

        // NHS
        val tvNHSinUK = findViewById<TextView>(R.id.tvNHSinUKNumber)
        tvNHSinUK.setOnClickListener {
            val phoneNum = tvNHSinUK.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+phoneNum))
            startActivity(callIntent)
        }
        //... //
    }
}
