package com.example.exercise4

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabDate = findViewById<Button>(R.id.datePicker)
        val datePicked = findViewById<TextView>(R.id.datePicked)
        val age = findViewById<TextView>(R.id.age)
        val c = Calendar.getInstance()
        var allowableInvestment = 0.0

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
                c.set(Calendar.YEAR, year)
                c.set(Calendar.MONTH, month)
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            }

        }

        fabDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view:View) {
                DatePickerDialog(this@MainActivity, dateSetListener,
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)

                ).show()
            }
        })

        calculateBtn.setOnClickListener {

            val sdf = SimpleDateFormat("dd MM YYYY")
            val currentDate = sdf.format(Date())
            val dateOfBirth = sdf.format(c.time)

            val now = sdf.parse(currentDate.toString())
            val before = sdf.parse(dateOfBirth.toString())

            var ages = (now.time - before.time)/1000/60/60/24/30/12
            var valid = true

            if(ages >=16 && ages<=20 ){
                allowableInvestment = 5000 * 0.3
                minSavingText.setText("RM 5000")
            }
            else if(ages >= 21 && ages<=25){
                allowableInvestment = 14000 * 0.3
                minSavingText.setText("RM 14000")
            }
            else if(ages >=26 && ages<=30){
                allowableInvestment = 29000 * 0.3
                minSavingText.setText("RM 29000")
            }
            else if(ages >= 31 && ages <= 35){
                allowableInvestment = 50000 * 0.3
                minSavingText.setText("RM 50000")
            }
            else if(ages >= 36 && ages<=40){
                allowableInvestment = 78000 * 0.3
                minSavingText.setText("RM 78000")
            }
            else if(ages >=41 && ages<=45){
                allowableInvestment = 116000 * 0.3
                minSavingText.setText("RM 116000")
            }
            else if(ages >=46 && ages<=50){
                allowableInvestment = 165000 * 0.3
                minSavingText.setText("RM165000")
            }
            else if(ages >=51 && ages <= 55){
                allowableInvestment = 228000 * 0.3
                minSavingText.setText("RM228000")
            }
            else if(ages<16 || ages >56){
                valid = false
            }

            if(valid == true){
                allowable.setText("Excess Amount of Saving can be Invested.")
                age.setText(ages.toString())
                datePicked.setText(dateOfBirth.toString())
            }
            else{
                allowable.setText("Investment are not allowed.")
            }

        }



    }
}


