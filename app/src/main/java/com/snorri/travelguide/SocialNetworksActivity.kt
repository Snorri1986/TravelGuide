package com.snorri.travelguide

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SocialNetworksActivity : AppCompatActivity() {

    // use checking method
    val ha:HotelsActivity = HotelsActivity()
    // ... //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_networks)

        // onClick methods to icons v 0.6.8
        val ivFacebook = findViewById<ImageView>(R.id.ivFacebook)
        ivFacebook.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            // facebook lite version v 0.6.8.1
            val isInstalled: Boolean = ha.isPackageInstalled("com.facebook.katana",pm)
            val isInstalled_lite: Boolean = ha.isPackageInstalled("com.facebook.lite",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.facebook.katana")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
                // ... //
            } else if(isInstalled_lite) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.facebook.lite")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
                // ... //
            }
            else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivTwitter = findViewById<ImageView>(R.id.ivTwitter)
        ivTwitter.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("com.twitter.android",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.twitter.android")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }

        val ivInstagram = findViewById<ImageView>(R.id.ivInstagram)
        ivInstagram.setOnClickListener {
            // check app
            val pm: PackageManager = this.getPackageManager()
            val isInstalled: Boolean = ha.isPackageInstalled("com.instagram.android",pm)
            if (isInstalled) {
                // Run app
                val launcher_intent: Intent = pm.getLaunchIntentForPackage("com.instagram.android")
                launcher_intent.addCategory(Intent.CATEGORY_LAUNCHER)
                this.startActivity(launcher_intent)
            } else {
                // open web link
                val web_launch_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com"))
                this.startActivity(web_launch_intent)
                // ... //
            }
            // ... //
        }
    }
}
