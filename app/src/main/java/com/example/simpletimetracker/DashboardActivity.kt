
package com.example.simpletimetracker

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DashboardActivity : AppCompatActivity() {

    private val tasks = mutableListOf<String>() // List to store logged tasks
    private lateinit var adapter: ArrayAdapter<String> // Adapter for ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Find views
        val logTaskButton = findViewById<Button>(R.id.btnLogTask)
        val taskListView = findViewById<ListView>(R.id.lvTasks)

        // Set up ListView with an ArrayAdapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        taskListView.adapter = adapter

        // Handle Log Task button click
        logTaskButton.setOnClickListener {
            val intent = Intent(this, TimeTrackingActivity::class.java)
            startActivityForResult(intent, 1) // Start activity for result
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Get the task details from TimeTrackingActivity
            val taskDetails = data.getStringExtra("taskDetails")
            if (taskDetails != null) {
                tasks.add(taskDetails) // Add to the list
                adapter.notifyDataSetChanged() // Refresh ListView
            }
        }
    }
}
