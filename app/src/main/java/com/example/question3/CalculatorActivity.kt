package com.example.question3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val numberInput1 = findViewById<EditText>(R.id.editTextNumber1)
        val numberInput2 = findViewById<EditText>(R.id.editTextNumber2)
        val resultDisplay = findViewById<TextView>(R.id.textViewResult)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        btnAdd.setOnClickListener {
            performOperation(numberInput1, numberInput2, resultDisplay, "add")
        }
        btnSubtract.setOnClickListener {
            performOperation(numberInput1, numberInput2, resultDisplay, "subtract")
        }
        btnMultiply.setOnClickListener {
            performOperation(numberInput1, numberInput2, resultDisplay, "multiply")
        }
        btnDivide.setOnClickListener {
            performOperation(numberInput1, numberInput2, resultDisplay, "divide")
        }
    }

    private fun performOperation(input1: EditText, input2: EditText, display: TextView, operation: String) {
        val number1 = input1.text.toString().toDoubleOrNull()
        val number2 = input2.text.toString().toDoubleOrNull()

        if (number1 == null || number2 == null) {
            display.text = "Please enter valid numbers"
            return
        }

        val result = when(operation) {
            "add" -> number1 + number2
            "subtract" -> number1 - number2
            "multiply" -> number1 * number2
            "divide" -> if (number2 != 0.0) number1 / number2 else "Cannot divide by zero"
            else -> ""
        }

        display.text = result.toString()
    }
}
