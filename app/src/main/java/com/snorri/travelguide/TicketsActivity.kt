package com.snorri.travelguide

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

// Activity for choice Tickets services.  v 0.6.6.2

class TicketsActivity : AppCompatActivity() {

    // use checking method
    val ha:HotelsActivity = HotelsActivity()
    // ... //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickets)

        // onClick methods to icons v 0.6.6.2
        val ivGoBibi = findViewById<ImageView>(R.id.ivGoibibi)
        ivGoBibi.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("com.goibibo",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.goibibo")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goibibo.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivMakeMyTrip = findViewById<ImageView>(R.id.ivMakeMyTrip)
        ivMakeMyTrip.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("com.makemytrip",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.makemytrip")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://makemytrip.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivSkyScanner = findViewById<ImageView>(R.id.ivSkyScanner)
        ivSkyScanner.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("net.skyscanner.android.main",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("net.skyscanner.android.main")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://skyscanner.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }
    }
}
