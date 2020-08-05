package com.snorri.travelguide

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Toast


// Activity for choice Hotel services. v 0.6.6.2

class HotelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)

        // onClick methods to icons  v 0.6.6.2
        val ivBooking = findViewById<ImageView>(R.id.ivBookingCom)
        ivBooking.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = isPackageInstalled("com.booking", pm)
            if (isInstalled) {
                // Run app
                val launcher_intent:Intent = pm.getLaunchIntentForPackage("com.booking")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://booking.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivAirBnB = findViewById<ImageView>(R.id.ivAirBnbRu)
        ivAirBnB.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = isPackageInstalled("com.airbnb.android", pm)
            if (isInstalled) {
                // Run app
                val launcher_intent:Intent = pm.getLaunchIntentForPackage("com.airbnb.android")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://airbnb.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivTrivago = findViewById<ImageView>(R.id.ivTrivagoCom)
        ivTrivago.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = isPackageInstalled("com.trivago", pm)
            if (isInstalled) {
                // Run app
                val launcher_intent:Intent = pm.getLaunchIntentForPackage("com.trivago")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://trivago.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivAgoda = findViewById<ImageView>(R.id.ivAgodaCom)
        ivAgoda.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = isPackageInstalled("com.agoda.mobile.consumer", pm)
            if (isInstalled) {
                // Run app
                val launcher_intent:Intent = pm.getLaunchIntentForPackage("com.agoda.mobile.consumer")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://agoda.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }
        // ... //
    }

    // check if app instaled v.0.6.6.2
    open fun isPackageInstalled(
        packageName: String, packageManager: PackageManager
    ): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
    // ... //
}
