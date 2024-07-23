package com.example.question3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val cities = arrayOf("New York", "London", "Tokyo", "New Delhi", "Sydney")
        val spinnerCities = findViewById<Spinner>(R.id.spinnerCities)
        val btnGetWeather = findViewById<Button>(R.id.btnGetWeather)
        val textViewWeather = findViewById<TextView>(R.id.textViewWeather)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        spinnerCities.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities)

        btnGetWeather.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            textViewWeather.text = ""  // Clear previous result

            // Handler to simulate network call delay
            Handler(Looper.getMainLooper()).postDelayed({
                val city = spinnerCities.selectedItem.toString()
                textViewWeather.text = getWeatherInfo(city)
                progressBar.visibility = View.GONE
            }, 2000)  // 2000 milliseconds for 2 seconds delay
        }
    }

    private fun getWeatherInfo(city: String): String {
        return when (city) {
            "New York" -> "Sunny, 24°C"
            "London" -> "Rainy, 15°C"
            "Tokyo" -> "Cloudy, 19°C"
            "New Delhi" -> "Hot, 35°C"
            "Sydney" -> "Windy, 22°C"
            else -> "Weather data not available"
        }
    }
}
