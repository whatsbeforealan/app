package edu.singaporetech.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
}