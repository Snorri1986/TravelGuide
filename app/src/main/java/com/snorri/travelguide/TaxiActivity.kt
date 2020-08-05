package com.snorri.travelguide

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

// Activity for choice Taxi services. v 0.6.6.2

class TaxiActivity : AppCompatActivity() {

    // use checking method
    val ha:HotelsActivity = HotelsActivity()
    // ... //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxi)

        // onClick methods to icons v 0.6.6.2
        val ivUber = findViewById<ImageView>(R.id.ivUber)
        ivUber.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("com.ubercab",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.ubercab")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uber.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivUklon = findViewById<ImageView>(R.id.ivUklon)
        ivUklon.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("ua.com.uklontaxi",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("ua.com.uklontaxi")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uklon.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }
    }
}
