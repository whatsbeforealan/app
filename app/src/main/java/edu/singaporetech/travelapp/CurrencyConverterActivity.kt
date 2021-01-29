package edu.singaporetech.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * Activity that displays UI to convert currency
 */
class CurrencyConverterActivity : AppCompatActivity() {

    val TAG: String = "CurrencyConverterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)

        // TODO findviewbyid for the UI elements
        val textCurrencyEditText = findViewById<EditText>(R.id.editTextCurrency)
        val textRateEditText = findViewById<EditText>(R.id.editTextRate)
        val sgdDollarEditText = findViewById<EditText>(R.id.editTextSingDollar)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // TODO set onClickListeners to all the buttons here
        convertButton.setOnClickListener{
            val convertedValue = calculateRate(
                sgdDollarEditText.text.toString().toFloat(),
                textRateEditText.text.toString().toFloat())
            Log.d("Value", convertedValue.toString())

            resultTextView.text = sgdDollarEditText.text.toString() + " SGD is %.2f".format(convertedValue) + " US Dollars"
        }
    }

    /**
     * Formula to calculate the destination currency
     * @param value
     * @param exchangeRate
     * @return
     */
    private fun calculateRate(value: Float, exchangeRate: Float): Float {
        return value * exchangeRate
    }

}