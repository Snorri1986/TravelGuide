package com.snorri.travelguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class EmergencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        // onclick listeners for flags.

        // Turkey.v.0.6.11
        val ivTurkeyListener = findViewById<ImageView>(R.id.ivTurkey)
        ivTurkeyListener.setOnClickListener {
            val intentTurkey = Intent(this, TurkeyEmergencyActivity::class.java)
            startActivity(intentTurkey)
        }
        // ... //

        // Eqypt. v.0.6.11
        val ivEqyptListener = findViewById<ImageView>(R.id.ivEgypt)
        ivEqyptListener.setOnClickListener {
            val intentEgypt = Intent(this, EgyptEmergencyActivity::class.java)
            startActivity(intentEgypt)
        }
        // ... //

        // Cyprus. v.0.6.11
        val ivCyprusListener = findViewById<ImageView>(R.id.ivCyprus)
        ivCyprusListener.setOnClickListener {
            val intentCyprus = Intent(this, CyprusEmergencyActivity::class.java)
            startActivity(intentCyprus)
        }
        // ... //

        // Greece. v.0.6.11
        val ivGreeceListener = findViewById<ImageView>(R.id.ivGreece)
        ivGreeceListener.setOnClickListener {
            val intentGreece = Intent(this, GreeceEmergencyActivity::class.java)
            startActivity(intentGreece)
        }
        // ... //

        // Australia. v.0.6.11
        val ivAustraliaListener = findViewById<ImageView>(R.id.ivAustralia)
        ivAustraliaListener.setOnClickListener {
            val intentAustralia = Intent(this, AustraliaEmergencyActivity::class.java)
            startActivity(intentAustralia)
        }
        // ... //

        // Spaine. v.0.6.11
        val ivSpaineListener = findViewById<ImageView>(R.id.ivSpaine)
        ivSpaineListener.setOnClickListener {
            val intentSpaine = Intent(this, SpaineEmergencyActivity::class.java)
            startActivity(intentSpaine)
        }
        // ... //

        // UK. v.0.6.11
        val ivUKListener = findViewById<ImageView>(R.id.ivUK)
        ivUKListener.setOnClickListener {
            val intentUK = Intent(this, UKEmergencyActivity::class.java)
            startActivity(intentUK)
        }
        // ... //

        // UAE. v.0.6.11
        val ivUAEListener = findViewById<ImageView>(R.id.ivUAE)
        ivUAEListener.setOnClickListener {
            val intentUAE = Intent(this, UAEEmergencyActivity::class.java)
            startActivity(intentUAE)
        }
        // ... //

        // Israel. v.0.6.11
        val ivIsraelListener = findViewById<ImageView>(R.id.ivIsrael)
        ivIsraelListener.setOnClickListener {
            val intentIsrael = Intent(this, IsraelEmergencyActivity::class.java)
            startActivity(intentIsrael)
        }
        // ... //
    }
}
