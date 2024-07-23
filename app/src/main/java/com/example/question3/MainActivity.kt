package com.example.question3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the buttons
        val btnOpenCalculator = findViewById<Button>(R.id.btnOpenCalculator)
        val btnOpenWeather = findViewById<Button>(R.id.btnOpenWeather)

        // Set up onClickListeners for each button to launch respective activities
        btnOpenCalculator.setOnClickListener {
            // Intent to launch CalculatorActivity
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        btnOpenWeather.setOnClickListener {
            // Intent to launch WeatherActivity
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
    }
}
