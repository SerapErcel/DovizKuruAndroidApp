package com.serapercel.dovizkuru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.serapercel.dovizkuru.model.Currency

class MainActivity : AppCompatActivity() {
    lateinit var tvDate: TextView
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val xml = XMLResult()
        val date = xml.xmlTarih()
        val currencyList = xml.xmlDoviz()

        tvDate = findViewById<TextView?>(R.id.tvDate)
        spinner = findViewById(R.id.spnCurrency)
        tvDate.text = "Bugün: $date"

        val adapter : ArrayAdapter<Currency> = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyList)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}