package edu.singaporetech.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent


/**
 * Lab 02: Travel App
 * Main Screen
 *
 * 2020-01-27: port to kotlin (jeannie)
 */
class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO findviewbyid for the UI elements

        // TODO set onClickListeners to all the buttons here
        //  or declare the onclick method within the layout XML?
    }
    fun launchCurrencyConverter(v: View){
        val intent = Intent(v.context, CurrencyConverterActivity::class.java)
        startActivity(intent)
    }
    fun launchTemperatureConverter(v: View){
        val intent = Intent(v.context, TempConverterActivity::class.java)
        startActivity(intent)
    }
    fun launchEmailActivity(v: View){
        val intent = Intent(v.context, EmailActivity::class.java)
        startActivity(intent)
    }
}