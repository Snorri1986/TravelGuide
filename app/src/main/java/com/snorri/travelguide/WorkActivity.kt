package com.snorri.travelguide

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_work.*
import java.util.*

class WorkActivity : AppCompatActivity() {

    // global GPS variables
    var latitude_gps_coordinate:Double? = null
    var longtitude_gps_coordinate:Double? = null
    // ... //

    // Location advice.
    val locWeatherAdvice:String = "Click \"Freeze location\" button before get weather information"
    // ... //


    // Global country name v 0.6.10
    var locationState:String? = null
    // ... //

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        // Show user native name
        val tvGreetingForuser = findViewById<TextView>(R.id.tvUserName)
        val usrNatName = intent.getStringExtra("UserNativeName")
        tvGreetingForuser.setText(usrNatName)
        // ... //

        // show user profile photo
        val ivUserPhoto = findViewById<ImageView>(R.id.local_profile_image)
        val usrGalleryPhoto = intent.getStringExtra("UsrImage")
        if (usrGalleryPhoto == null) {
            ivUserPhoto.setImageResource(R.drawable.ic_crop_original_black_24dp)
        } else {
            ivUserPhoto.setImageURI(Uri.parse(usrGalleryPhoto))
        }
        // ... //


        //BUTTON CLICK
        btn_add_local_photo.setOnClickListener {

            //check runtime permission
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }

        // Get weather
        val btnCallWeather = findViewById<Button>(R.id.btnWeather)
        btnCallWeather.setOnClickListener {
            val intentCallWeather = Intent(this, WeatherActivity::class.java)
            startActivity(intentCallWeather)
        }
        // ... //

        // Store GPS coordinates.
        val btnFLoc = findViewById<Button>(R.id.btnFreezeLoc)
        btnFLoc.setOnClickListener {
            val dbHandler = UserDBHelper(this, null)
            var res : Boolean = dbHandler.storeGps(latitude_gps_coordinate!!,longtitude_gps_coordinate!!)
            if(res) Toast.makeText(this, "Location freezed", Toast.LENGTH_LONG).show()
        }
        // ... //


        LocationHelper().startListeningUserLocation(this , object : LocationHelper.MyLocationListener {
            override fun onLocationChanged(location: Location) {

                latitude_gps_coordinate = location.latitude
                longtitude_gps_coordinate = location.longitude


                var tvUserGPS = findViewById<TextView>(R.id.tvLocation)
                tvUserGPS.setText(getGpsAddress(location.latitude,location.longitude))

                // show current latitude
                var tvLat = findViewById<TextView>(R.id.tvLat)
                tvLat.setText(location.latitude.toString())

                // show current longtitude
                var tvLongtit = findViewById<TextView>(R.id.tvLong)
                tvLongtit.setText(location.longitude.toString())
                // ... //
            }
        })
        // ... //

        // Wheater on location advice.
        Toast.makeText(this,locWeatherAdvice, Toast.LENGTH_LONG).show()
        // ... //

        // go to new trip activity v 0.6.10.1
        val btnServs = findViewById<Button>(R.id.btnServices)
        btnServs.setOnClickListener {
            val intentCallNewTrip = Intent(this, ServicesActivity::class.java)
            startActivity(intentCallNewTrip)
        }
        // ... //

        // show my location on Google Map Application v 0.6.7
        val btnGoogleMap = findViewById<Button>(R.id.btnMapLocation)
        btnGoogleMap.setOnClickListener {
            val pm: PackageManager = this.getPackageManager()
            val googleMapsIntent:Intent = pm.getLaunchIntentForPackage("com.google.android.apps.maps")
            this.startActivity(googleMapsIntent)
        }
        // ... //

        // send e-mail v 0.6.8
        val btnGmail = findViewById<Button>(R.id.btnSendMsg)
        btnGmail.setOnClickListener {
            val pm: PackageManager = this.getPackageManager()
            val runGmail:Intent = pm.getLaunchIntentForPackage("com.google.android.gm")
            this.startActivity(runGmail)
        }
        // ... //

        // social networks v 0.6.8
        val btnSN = findViewById<Button>(R.id.btnSocialNetwrks)
        btnSN.setOnClickListener {
            val intentCallSN = Intent(this, SocialNetworksActivity::class.java)
            startActivity(intentCallSN)
        }
        // ... //

        // run camera application v 0.6.9
        val btnCamera = findViewById<Button>(R.id.btnPhoto)
        btnCamera.setOnClickListener {
            val pm: PackageManager = this.getPackageManager()
            val cameraIntent:Intent = pm.getLaunchIntentForPackage("com.hmdglobal.app.camera")
            this.startActivity(cameraIntent)
        }
        // ... //

        // Currency exchange button v 0.6.10
        val btnCurrencyExchange = findViewById<Button>(R.id.btnCurExchange)
        btnCurrencyExchange.setOnClickListener {
            val intentCallCurrencyExchange = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.travelex.com/currency-converters"))
            startActivity(intentCallCurrencyExchange)
        }
        // ... //


        // Location news button v 0.6.10
        val btnLocationHistory = findViewById<Button>(R.id.btnLockHistory)
        btnLocationHistory.setOnClickListener {
            val uri = Uri.parse("http://www.google.com/#q=$locationState")
            val intentGoogleSearch = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intentGoogleSearch)
        }
        // ... //

    }

    // convert GPS coordinates to the country name
    fun getGpsAddress(lat:Double,longtit:Double) : String  {
        var gcd = Geocoder(baseContext,Locale.getDefault())
        var addrList:MutableList<Address> = gcd.getFromLocation(lat,longtit,1)
        val countryName:String = addrList[0].countryName
        // save into global variable v 0.6.10
        locationState = countryName
        // ... //
        return countryName
    }
    // ... //


    // Get real file path
    open fun getRealPathFromURI(uri: Uri?): String? {
        val cursor: Cursor = contentResolver.query(uri, null, null, null, null)
        cursor.moveToFirst()
        val idx: Int = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
        return cursor.getString(idx)
    }
    // ... //

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
     override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            local_profile_image.setImageURI(data?.data)
            // Add image to DB
            val usrLogin = intent.getStringExtra("UserLogin")
            val dbHandler = UserDBHelper(this, null)
            // Get real file path
            var imageRealPathTest = getRealPathFromURI(data?.data) // work perfect
            // ... ///
            // Save on DB
            var res : Boolean = dbHandler.addUserImage(imageRealPathTest,usrLogin)
            // ... //
            if(res) Toast.makeText(this, "User image add to DB", Toast.LENGTH_LONG).show()
        }
    }
}
