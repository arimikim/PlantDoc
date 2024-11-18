package com.example.plantdoc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubmitReportActivity : AppCompatActivity() {

    private lateinit var descriptionEditText: EditText
    private lateinit var selectedImageView: ImageView
    private lateinit var uploadImageButton: Button
    private lateinit var submitReportButton: Button

    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_report)

        descriptionEditText = findViewById(R.id.problem_description)
        selectedImageView = findViewById(R.id.selected_image)
        uploadImageButton = findViewById(R.id.upload_image_button)
        submitReportButton = findViewById(R.id.submit_report_button)

        // Handle image upload
        uploadImageButton.setOnClickListener {
            openGallery()
        }

        // Handle report submission
        submitReportButton.setOnClickListener {
            val description = descriptionEditText.text.toString()

            if (description.isBlank() || selectedImageUri == null) {
                Toast.makeText(this, "Please provide a description and upload a photo.", Toast.LENGTH_SHORT).show()
            } else {
                // For now, just show a toast
                Toast.makeText(this, "Report submitted successfully!", Toast.LENGTH_SHORT).show()


            }
        }
    }

    // Open the gallery to select an image
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, 100)
    }

    // Handle the result of the image selection
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            selectedImageUri = data?.data
            selectedImageView.setImageURI(selectedImageUri)
        }
    }
}
