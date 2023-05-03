package com.serapercel.dovizkuru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tvDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val xml = XMLResult()
        val date = xml.xmlTarih()

        tvDate = findViewById<TextView?>(R.id.tvDate)
        tvDate.text = "Bugün: $date"
    }
}