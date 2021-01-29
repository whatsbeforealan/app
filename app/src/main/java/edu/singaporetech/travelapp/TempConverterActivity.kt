package edu.singaporetech.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.RadioGroup

/**
 * Activity that displays UI to convert temperature
 */
class TempConverterActivity : AppCompatActivity() {

    val TAG: String = "TempConverter"
    private var temperature: Char = 'F'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_converter)

        // TODO findviewbyid for the UI elements
        val inputEditText = findViewById<EditText>(R.id.editTextTemp)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        // TODO set onClickListeners to all the buttons here
        convertButton.setOnClickListener{
            // Get the checked radio button id from radio group
            val id: Int = radioGroup.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group

                val input = inputEditText.text.toString()

                if(id == R.id.radioFahrenheit){
                    val result = convertCelsiusToFahrenheit(input.toFloat())
                    Log.d("Result F", result.toString())
                    resultTextView.text = input + " Celsius is %.2f".format(result) + " Fahrenheit"
                }else{
                    val result = convertFahrenheitToCelsius(input.toFloat())
                    Log.d("Result C", result.toString())
                    resultTextView.text = input + " Fahrenheit is %.2f".format(result) + " Celsius"
                }
            }
        }

        clearButton.setOnClickListener {
            inputEditText.text.clear()
            resultTextView.text = ""
        }
    }

    private fun convertFahrenheitToCelsius(fahrenheit: Float): Float {
        val celsius = (fahrenheit - 32) * 5/9
        return celsius
    }

    /**
     * Converts celsius to fahrenheit
     * @param celsius temperature in c
     * @return
     */
    fun convertCelsiusToFahrenheit(celsius: Float): Float {
        val fahrenheit = (celsius * 9/5) + 32
        return fahrenheit
    }
}