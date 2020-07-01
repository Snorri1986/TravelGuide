package com.snorri.travelguide

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper(context: Context,
                   factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        factory, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USER_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_LOGIN + " TEXT," +
                  COLUMN_PASWORD + " TEXT," +
                  NATIVE_NAME + " TEXT" + ")")
        db.execSQL(CREATE_USER_TABLE)

        // table for user image
        val CREATE_IMAGE_TABLE = ("CREATE TABLE " +
                USR_PROFILE_TAB + "("
                + COLUMN_LOGIN + " TEXT," +
                USR_PROFILE_IMAGE + " TEXT" + ")")
        db.execSQL(CREATE_IMAGE_TABLE)
        // ... //


        // table for user's GPS location coordinate.
        val CREATE_GPSLOC_TABLE = ("CREATE TABLE " +
                USR_GPS_TAB + "("
                + COLUMN_LAT + " REAL," +
                COLUMN_GPS_NAT_NAME + " TEXT,"  +
                COLUMN_LONG + " REAL" + ")")
        db.execSQL(CREATE_GPSLOC_TABLE)
        // ... //


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addName(usr: User) {
        val values = ContentValues()
        values.put(COLUMN_LOGIN, usr.Login)
        values.put(COLUMN_PASWORD, usr.Password)
        values.put(NATIVE_NAME, usr.userNativeName)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null,values)
        db.close()
    }

    // add user profile image
    fun addUserImage(imgPath:String?,userLogin:String) : Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_LOGIN,userLogin)
        values.put(USR_PROFILE_IMAGE,imgPath)
        db.insert(USR_PROFILE_TAB,null,values)
        if(!imgPath!!.isEmpty() && !userLogin.isEmpty()) {
            return true
        } else {
            return false
        }
    }
    // ... //

    // fetch user image
   fun getUserImage(login: String): String? {
        val db = this.writableDatabase
        val selectQuery = "SELECT  * FROM $USR_PROFILE_TAB WHERE $COLUMN_LOGIN = ?"
        db.rawQuery(selectQuery, arrayOf(login)).use { // .use requires API 16
            if (it.moveToFirst()) {
                val usrImgUri : String = it.getString(it.getColumnIndex(USR_PROFILE_IMAGE))
                return usrImgUri
            }
        }
        return null
    }
    // ... //

    // get user name and password
    fun getUser(login: String): User? {
        val db = this.writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE $COLUMN_LOGIN = ?"
        db.rawQuery(selectQuery, arrayOf(login)).use { // .use requires API 16
            if (it.moveToFirst()) {
                val authenticUser = User()
                authenticUser.Login= it.getString(it.getColumnIndex(COLUMN_LOGIN))
                authenticUser.Password = it.getString(it.getColumnIndex(COLUMN_PASWORD))
                authenticUser.userNativeName = it.getString(it.getColumnIndex(NATIVE_NAME))
                return authenticUser
            }
        }
        return null
    }

    // Add user GPS coordinate.
    fun storeGps(gpsLat:Double,gpsLong:Double,nName:String = "User"):Boolean {
        var res:Boolean = false
        val db = this.writableDatabase
        val values = ContentValues()
            values.put(COLUMN_LAT, gpsLat)
            values.put(COLUMN_GPS_NAT_NAME, nName)
            values.put(COLUMN_LONG, gpsLong)
            db.insert(USR_GPS_TAB, null, values)
        if(!gpsLat.toString().isEmpty() && !gpsLong.toString().isEmpty()) {
            res = true
            return res
        } else {
            return res
        }
    }
    // ... //

    // Get user stored GPS
    fun getUserStoredGps(uName: String): UserLocator? {
        val db = this.writableDatabase
        val selectQuery = "SELECT  * FROM $USR_GPS_TAB WHERE $COLUMN_GPS_NAT_NAME = ?"
        db.rawQuery(selectQuery, arrayOf(uName)).use { // .use requires API 16
            if (it.moveToFirst()) {
                val curUser = UserLocator()
                curUser.latitude= it.getDouble(it.getColumnIndex(COLUMN_LAT))
                curUser.longtitude = it.getDouble(it.getColumnIndex(COLUMN_LONG))
                return curUser
            }
        }
        return null
    }
    // ... //

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "users.db"
        val TABLE_NAME = "TravelUsers"
        val COLUMN_LOGIN = "Login"
        val COLUMN_PASWORD = "Password"
        val NATIVE_NAME = "Name"
        val USR_PROFILE_IMAGE = "UsrImage"
        val USR_PROFILE_TAB = "UserImagesTable"
        val USR_GPS_TAB = "UserGps"
        val COLUMN_LAT = "GpsLat"
        val COLUMN_LONG = "GpsLong"
        val COLUMN_GPS_NAT_NAME = "GpsDefaultUser"
    }
}
