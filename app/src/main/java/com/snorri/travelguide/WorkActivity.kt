package com.snorri.travelguide

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity : AppCompatActivity() {

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
    }

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
