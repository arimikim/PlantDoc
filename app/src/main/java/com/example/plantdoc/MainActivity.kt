package com.example.plantdoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitReportButton: Button = findViewById(R.id.submit_report_button)
        val viewDiagnosesButton: Button = findViewById(R.id.view_diagnoses_button)

        // Navigate to Submit Report Screen
        submitReportButton.setOnClickListener {
            val intent = Intent(this, SubmitReportActivity::class.java)
            startActivity(intent)
        }

        // Navigate to View Past Diagnoses Screen
        viewDiagnosesButton.setOnClickListener {
            val intent = Intent(this, ViewDiagnosesActivity::class.java)
            startActivity(intent)
        }
    }
}
