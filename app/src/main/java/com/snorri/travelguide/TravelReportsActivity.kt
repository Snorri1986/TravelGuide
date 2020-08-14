package com.snorri.travelguide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class TravelReportsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_reports)

        // Get user's trips from DB. v 0.6.11
        // test code 13.08.2020
        //val dbHandler = UserDBHelper(this, null)
        //var userTripsArray = ArrayList<String>(dbHandler.getAllUserTripsReport())
        // ... //

        // Fill activity from db v.0.6.11
        // test code 13.08.2020
        var lvReports = findViewById<ListView>(R.id.list_of_trips)
        val adapter = ArrayAdapter(this, R.layout.user_trips, getTripsFromDB())
        lvReports.adapter = adapter
        // ... //
    }

    // test code 14.08.2020
    // Get info from DB v 0.6.11
    fun getTripsFromDB(): ArrayList<String> {
        val dbHandler = UserDBHelper(this, null)
        var userTripsArray = ArrayList<String>(dbHandler.getAllUserTripsReport())
        return userTripsArray
    }
    // ... //
}
