package com.example.shms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubmitComplaint extends AppCompatActivity {
    private EditText mComplaintEditText;
    private Button mComplaintButton;
    private DatabaseHelperComplaint mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_complaint);

        // Initialize views
        mComplaintEditText = findViewById(R.id.complaint_edit_text);
        mComplaintButton = findViewById(R.id.button_complaint);

        // Initialize database helper
        mDbHelper = new DatabaseHelperComplaint(this);

        // Set click listener for the button
        mComplaintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the complaint text from the edit text
                String complaint = mComplaintEditText.getText().toString().trim();

                // Insert the complaint into the database
                long result = mDbHelper.insertComplaint(complaint);

                // Check if the insertion was successful
                if (result != -1) {
                    Toast.makeText(SubmitComplaint.this, "Complaint registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubmitComplaint.this, "Error registering complaint", Toast.LENGTH_SHORT).show();
                }

                // Clear the edit text
                mComplaintEditText.getText().clear();

            }
        });
    }

}