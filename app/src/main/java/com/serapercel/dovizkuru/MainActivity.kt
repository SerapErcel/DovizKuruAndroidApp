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

class MainActivity : AppCompatActivity() {
    lateinit var tvDate: TextView
    lateinit var spinner: Spinner
    lateinit var tvSpAlis: TextView
    lateinit var tvSpSatis: TextView
    lateinit var tvBankaAlis: TextView
    lateinit var tvBankaSatis: TextView

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
        tvSpAlis = findViewById<TextView?>(R.id.tvSpAlis)
        tvSpSatis = findViewById<TextView?>(R.id.tvSpSatis)
        tvBankaAlis = findViewById<TextView?>(R.id.tvBankaAlis)
        tvBankaSatis = findViewById<TextView?>(R.id.tvBankaSatis)

        tvDate.text = "Bugün: $date"

        val currencyNameList = mutableListOf<String>()
        currencyList.forEach { currencyNameList.add(it.Isim) }

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyNameList)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tvSpAlis.text = currencyList[position].ForexBuying
                tvSpSatis.text = currencyList[position].ForexSelling
                tvBankaAlis.text = currencyList[position].BanknoteBuying
                tvBankaSatis.text = currencyList[position].BanknoteSelling

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}