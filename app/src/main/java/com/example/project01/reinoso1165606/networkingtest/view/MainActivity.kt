package com.example.project01.reinoso1165606.networkingtest.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.project01.reinoso1165606.networkingtest.R
import com.example.project01.reinoso1165606.networkingtest.services.RetrofitService
import com.example.project01.reinoso1165606.networkingtest.services.RetrofitServiceFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // getting the text label that will display the data
        val label = findViewById<TextView>(R.id.textLabel)

        // creating an instance of the retrofit service
        val service = RetrofitServiceFactory.makeRetrofitService()

        // launching the request in a coroutine
        lifecycleScope.launch {
            // getting the results from the API call - London, ON coordinates passed
            val weatherResult =
            service.listWeather(42.9929,-81.2418) // this is a suspend function

            // printing the full result on console
            println(weatherResult)

            // and showing the current temperature from the result in the UI
            label.text = "Current temperature: ${weatherResult.current.temperature_2m}°C"
        }




    }
}