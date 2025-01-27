
package com.example.simpletimetracker

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TimeTrackingActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_tracking)

        // Find views
        val taskNameField = findViewById<EditText>(R.id.etTaskName)
        val dateField = findViewById<EditText>(R.id.etDate)
        val startTimeField = findViewById<EditText>(R.id.etStartTime)
        val endTimeField = findViewById<EditText>(R.id.etEndTime)
        val logButton = findViewById<Button>(R.id.btnLogTask)

        // Handle Log Task button click
        logButton.setOnClickListener {
            val taskName = taskNameField.text.toString()
            val date = dateField.text.toString()
            val startTime = startTimeField.text.toString()
            val endTime = endTimeField.text.toString()

            if (taskName.isNotEmpty() && date.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty()) {
                // Format task details
                val taskDetails = "Task: $taskName\nDate: $date\nTime: $startTime - $endTime"

                // Send the task details back to DashboardActivity
                val resultIntent = Intent()
                resultIntent.putExtra("taskDetails", taskDetails)
                setResult(Activity.RESULT_OK, resultIntent)
                finish() // Close the activity
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

