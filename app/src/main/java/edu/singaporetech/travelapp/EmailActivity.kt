package edu.singaporetech.travelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import org.w3c.dom.Text
import android.widget.Toast


/**
 * Activity that emails your friend with a message
 */
class EmailActivity : AppCompatActivity() {

    val TAG: String = "EmailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        // TODO findviewbyid for the UI elements
        val textNameEditText = findViewById<EditText>(R.id.editTextName)
        val textEmailEditText = findViewById<EditText>(R.id.editTextEmail)
        val textCityEditText = findViewById<EditText>(R.id.editTextCity)
        val previewButton = findViewById<Button>(R.id.previewButton)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val textViewPreview = findViewById<TextView>(R.id.previewText)

        // TODO set onClickListeners to all the buttons here
        previewButton.setOnClickListener {
            val stringName = textNameEditText.text.toString()
            val stringCity = textCityEditText.text.toString()

            textViewPreview.text = createEmailMessage(stringName, stringCity)
        }
        //  or declare the onclick method within the layout XML?
        sendButton.setOnClickListener {
            sendEmail(
                    textEmailEditText.text.toString(),
                    "Going on vacation!",
                    createEmailMessage(textNameEditText.text.toString(), textCityEditText.text.toString()))
        }
        Log.d(TAG, "onCreate")
        Log.d(TAG, createEmailMessage("Jeannie", "Los Angeles"))
    }

    /**
     * Call an intent to start the email app
     */
    fun sendEmail(name: String, subject: String, message: String) {

        // TODO: Use an intent to launch an email app.
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(name))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)
        startActivity(mIntent)
    }

    /**
     * Creates the string to send in the email message
     * @param name
     * @param city
     * @return the email message
     */
    private fun createEmailMessage(name: String, city: String): String {

        val emailMessage: String = getString(R.string.hey) + " " + name + " " + getString(R.string.im_going_to) + " " + city + "!"

        return emailMessage
    }

}