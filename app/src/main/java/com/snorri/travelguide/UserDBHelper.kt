package com.snorri.travelguide

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteCursor
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
                COLUMN_LONG + " REAL" +
                ")")
        db.execSQL(CREATE_GPSLOC_TABLE)
        // ... //


        // table for store user's trips v 0.6.6.1
        val CREATE_TRIPS_TABLE = ("CREATE TABLE " +
                USR_TRIPS_TAB + "("
                + COLUMN_TRIP_NAME + " TEXT," +
                COLUMN_START_DATE + " TEXT,"  +
                COLUMN_END_DATE + " TEXT," +
                COLUMN_FROM_CITY + " TEXT," +
                COLUMN_TO_CITY + " TEXT," +
                COLUMN_TRANSPORT + " TEXT" +
                COLUMN_HOTEL + " TEXT," +
                COLUMN_SPENDINGS + " TEXT," +
                COLUMN_USER_NAME + " TEXT" + ")")
        db.execSQL(CREATE_TRIPS_TABLE)
        // ... //
    }



    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // upgrade for every table v 0.6.6.1
        var dbString:String = db.toString()
        when(dbString) {
            TABLE_NAME -> db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
            USR_PROFILE_TAB -> db.execSQL("DROP TABLE IF EXISTS " + USR_PROFILE_TAB)
            USR_GPS_TAB -> db.execSQL("DROP TABLE IF EXISTS " + USR_GPS_TAB)
            USR_TRIPS_TAB -> db.execSQL("DROP TABLE IF EXISTS " + USR_TRIPS_TAB)
        }
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


    // add user's trip v 0.6.6.1
    fun addUserTrip(voyage: Trip,nName:String = "User") {
        val values = ContentValues()
        values.put(COLUMN_TRIP_NAME, voyage.trName)
        values.put(COLUMN_START_DATE, voyage.trStartDate)
        values.put(COLUMN_END_DATE,voyage.trEndDate)
        values.put(COLUMN_FROM_CITY, voyage.trFromCity)
        values.put(COLUMN_TO_CITY, voyage.trToCity)
        values.put(COLUMN_TRANSPORT, voyage.trVehicle)
        values.put(COLUMN_HOTEL, voyage.trHotel)
        values.put(COLUMN_SPENDINGS, voyage.trPlannedSpendings)
        values.put(COLUMN_USER_NAME, nName)
        val db = this.writableDatabase
        db.insert(USR_TRIPS_TAB, null,values)
        db.close()
    }
    // ... //

    // Get user's trips for report v 0.6.11
    // test code 13.08.2020
    fun getAllUserTripsReport(nName:String = "User") : ArrayList<String> {
        val list = ArrayList<String>()
        val db = this.readableDatabase
        val c = db.rawQuery(
            "SELECT TripName FROM " + USR_TRIPS_TAB.toString() + " WHERE Uname = " + nName.toString(),
            null
        ) as SQLiteCursor

        if (c.moveToFirst()) {
            do {
                list.add(c.getString(c.getColumnIndexOrThrow("TripName")))
            } while (c.moveToNext())
        }
        c.close()
        db.close()
        return list
    }
    // ... //


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


    // clean USR_GPS_TAB table v 0.6.6.2
    fun cleanUserGpsTable() {
        val db = this.writableDatabase
        db.execSQL("delete from " + USR_GPS_TAB)
        db.close()
    }
    // ... //

    // v 0.6.6.1
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
        val USR_TRIPS_TAB = "UserTrips"
        val COLUMN_TRIP_NAME = "TripName"
        val COLUMN_START_DATE = "sDate"
        val COLUMN_END_DATE = "eDate"
        val COLUMN_FROM_CITY = "FromCity"
        val COLUMN_TO_CITY = "ToCity"
        val COLUMN_TRANSPORT = "Vehicle"
        val COLUMN_HOTEL = "Hotel"
        val COLUMN_SPENDINGS = "Spendings"
        val COLUMN_USER_NAME = "Uname"
        // ... //
    }
}
