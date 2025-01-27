
package com.example.simpletimetracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LogTimeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_time)

        val taskNameField = findViewById<EditText>(R.id.etTaskName)
        val startTimeField = findViewById<EditText>(R.id.etStartTime)
        val endTimeField = findViewById<EditText>(R.id.etEndTime)
        val logButton = findViewById<Button>(R.id.btnLogTask)

        logButton.setOnClickListener {
            val taskName = taskNameField.text.toString()
            val startTime = startTimeField.text.toString()
            val endTime = endTimeField.text.toString()

            if (taskName.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty()) {
                // Log task details (future: save to database)
                Toast.makeText(this, "Task '$taskName' logged successfully!", Toast.LENGTH_SHORT).show()
                finish() // Return to the dashboard
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
