package com.snorri.travelguide

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_new_travel.*
import java.util.*


class NewTravelActivity : AppCompatActivity() {

    // Variable for Clear button v.0.6.6.1
    val nullValue: String = ""
    // ... //


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_travel)


        // button Cancel
        val buttonCancelTrip = findViewById<Button>(R.id.btnCancelTrip)
        buttonCancelTrip.setOnClickListener {
            val intentCallWA = Intent(this, WorkActivity::class.java)
            startActivity(intentCallWA)
        }
        // ... //

        // button Clear. v.0.6.6.1
        val btnClearTrip = findViewById<Button>(R.id.btnErase)
        btnClearTrip.setOnClickListener {
            setNull()
        }
        // ... //


        // Pick date for StartDate  v.0.6.6.1
        val myCalendar = Calendar.getInstance()
        var etStartDate = findViewById<EditText>(R.id.tfStartDate)

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val date_format = dayOfMonth.toString() + "." + monthOfYear.toString() + "." + year.toString()
            etStartDate.setText(date_format)
        }

        etStartDate.setOnClickListener {
            DatePickerDialog(this, dateSetListener,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        // ... //

        // Pick date for EndDate v.0.6.6.1
        val myCalendarEd = Calendar.getInstance()
        var etEndDate = findViewById<EditText>(R.id.tfEndDate)

        val dateSetListenerEd = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendarEd.set(Calendar.YEAR, year)
            myCalendarEd.set(Calendar.MONTH, monthOfYear)
            myCalendarEd.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val date_format_ed = dayOfMonth.toString() + "." + monthOfYear.toString() + "." + year.toString()
            etEndDate.setText(date_format_ed)
        }

        etEndDate.setOnClickListener {
            DatePickerDialog(this, dateSetListenerEd,
                myCalendarEd.get(Calendar.YEAR),
                myCalendarEd.get(Calendar.MONTH),
                myCalendarEd.get(Calendar.DAY_OF_MONTH)).show()
        }
        // ... //


        // Spinner for vehicles v.0.6.6.1
        // access the items of the list
        val trav_vehicles = resources.getStringArray(R.array.TravelVehicles)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.vehicleSpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, trav_vehicles)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@NewTravelActivity,
                        getString(R.string.selected_item) + " " +
                                "" + trav_vehicles[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        // Save user trip v.0.6.6.1
        val btnSaveTrip = findViewById<Button>(R.id.btnSaveTrip)
        btnSaveTrip.setOnClickListener {
            val dbHandler = UserDBHelper(this, null)
            val usrTrip = Trip(
                tfNewTrip.text.toString(),
                tfStartDate.text.toString(),
                tfEndDate.text.toString(),
                tfFromLocation.text.toString(),
                tfToLocation.text.toString(),
                tfTransport.text.toString(),
                tfAcomodation.text.toString(),
                tfMoney.text.toString()
            )
            dbHandler.addUserTrip(usrTrip)
            Toast.makeText(this,"Trip saved", Toast.LENGTH_LONG).show()
        }
        // ... //

        // Taxi button. ready to commit v.0.6.6.2
        val btnTaxi = findViewById<Button>(R.id.btnTaxxis)
        btnTaxi.setOnClickListener {
            val intentbtnTaxi = Intent(this, TaxiActivity::class.java)
            startActivity(intentbtnTaxi)
        }
        // ... //

        // Hotels button. ready to commit v.0.6.6.2
        val btnHotels = findViewById<Button>(R.id.btnAcomHotels)
        btnHotels.setOnClickListener {
            val intentbtnHotels = Intent(this, HotelsActivity::class.java)
            startActivity(intentbtnHotels)
        }
        // ... //

        // Tickets button. ready to commit v.0.6.6.2
        val btnTickets = findViewById<Button>(R.id.btnTransportPass)
        btnTickets.setOnClickListener {
            val intentbtnTickets = Intent(this, TicketsActivity::class.java)
            startActivity(intentbtnTickets)
        }
        // ... //

        // reminder v.0.6.9
        val btnReminder = findViewById<ImageButton>(R.id.btnReminder)
        btnReminder.setOnClickListener {
            val cal = Calendar.getInstance()
            val intent = Intent(Intent.ACTION_EDIT)
            intent.type = "vnd.android.cursor.item/event"
            intent.putExtra("beginTime", cal.timeInMillis)
            intent.putExtra("allDay", false)
            intent.putExtra("rrule", "FREQ=DAILY")
            intent.putExtra("endTime", cal.timeInMillis + 60 * 60 * 1000)
            intent.putExtra("title", "Name of trip")
            startActivity(intent)
        }
        // ... //

    }

    // ... //

    // For CLEAR button v.0.6.6.1
    fun setNull() {
        val nT = findViewById<TextView>(R.id.tfNewTrip)
        val sD = findViewById<TextView>(R.id.tfStartDate)
        val eD = findViewById<TextView>(R.id.tfEndDate)
        val fLocation = findViewById<TextView>(R.id.tfFromLocation)
        val tLocation = findViewById<TextView>(R.id.tfToLocation)
        val vVehicle = findViewById<TextView>(R.id.tfTransport)
        val vHotel = findViewById<TextView>(R.id.tfAcomodation)
        val vMoney = findViewById<TextView>(R.id.tfMoney)

        nT.setText(nullValue)
        sD.setText(nullValue)
        eD.setText(nullValue)
        fLocation.setText(nullValue)
        tLocation.setText(nullValue)
        vVehicle.setText(nullValue)
        vHotel.setText(nullValue)
        vMoney.setText(nullValue)
    }
}
    // ... //



