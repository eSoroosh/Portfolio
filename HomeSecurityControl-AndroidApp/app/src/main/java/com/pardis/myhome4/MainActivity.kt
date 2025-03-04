package com.pardis.myhome4


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pardis.myhome4.ui.theme.MyHome4Theme

import android.telephony.SmsManager
import android.widget.Button
import android.graphics.Color
import android.widget.TextView
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyHome4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // do something here
                }
            }
        }

        val phoneNumber = getString(R.string.security_phonenumber)  // Replace with your specific number
        val armCommand = getString(R.string.security_arm_command)
        val disarmCommand = getString(R.string.security_disarm_command)
        val checkCommand = getString(R.string.security_check_command)

        val armedMessage = getString(R.string.security_armed_msg)
        val disarmedMessage = getString(R.string.security_disarmed_msg)

        this.setContentView(R.layout.main_activity)

//        // Example code to send message
        val sendArmButton: Button = findViewById(R.id.buttonArm)
        val sendDisarmButton: Button = findViewById(R.id.buttonDisarm)
        val sendCheckButton: Button = findViewById(R.id.buttonCheck)


//        // Use SmsManager to send message
        sendArmButton.setOnClickListener {

            val smsManager = SmsManager.getDefault()
            // Get the SmsManager from the context
            //val smsManager = Context.getSystemService(SmsManager::class.java)
            // Send the text message
            try{
                smsManager.sendTextMessage(phoneNumber, null, armCommand, null, null)
                showState(name = armedMessage, color = Color.MAGENTA, smsState = "Message sent...")
            }
            catch (e: Exception){
                showState(name = "Error!", color = Color.RED, smsState = "Failed to send SMS. Error: ${e.message}")
            }

        }

        sendArmButton.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Button is touched
                    view.background.alpha = 150 // Adjust transparency or other visual effects
                }
                MotionEvent.ACTION_UP -> {
                    // Button is released
                    view.background.alpha = 255 // Restore original state
                }
            }
            false // Return 'false' to ensure that the click event is also processed
        }

//
        sendDisarmButton.setOnClickListener {
            // Get the SmsManager from the context
            val smsManager = SmsManager.getDefault()
            // Send the text message
            try {
                smsManager.sendTextMessage(phoneNumber, null, disarmCommand, null, null)
                showState(name = disarmedMessage, color = Color.GREEN, smsState = "Message sent...")
            }
            catch (e: Exception){
                showState(name = "Error!", color = Color.RED, smsState = "Failed to send SMS. Error: ${e.message}")
            }
        }

        sendDisarmButton.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Button is touched
                    view.background.alpha = 150 // Adjust transparency or other visual effects
                }
                MotionEvent.ACTION_UP -> {
                    // Button is released
                    view.background.alpha = 255 // Restore original state
                }
            }
            false // Return 'false' to ensure that the click event is also processed
        }

        sendCheckButton.setOnClickListener {
            // Get the SmsManager from the context
            val smsManager = SmsManager.getDefault()
            // Send the text message
            try {
                smsManager.sendTextMessage(phoneNumber, null, checkCommand, null, null)
                //showState(name = disarmedMessage, color = Color.GREEN, smsState = "Message sent...")
                Toast.makeText(this ,"Message sent...", Toast.LENGTH_SHORT).show()
            }
            catch (e: Exception){
                showState(name = "Error!", color = Color.RED, smsState = "Failed to send SMS. Error: ${e.message}")
            }
        }

        sendCheckButton.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Button is touched
                    view.background.alpha = 150 // Adjust transparency or other visual effects
                }
                MotionEvent.ACTION_UP -> {
                    // Button is released
                    view.background.alpha = 255 // Restore original state
                }
            }
            false // Return 'false' to ensure that the click event is also processed
        }
    }

    private fun showState(name: String, color: Int = Color.BLACK, smsState: String) {
        val msgLabel: TextView = findViewById(R.id.textView)
        msgLabel.text = name
        msgLabel.setTextColor(color)
        Toast.makeText(this ,smsState, Toast.LENGTH_SHORT).show()
    }


}

