package com.example.shms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MaintenanceRequestActivity extends AppCompatActivity {

    private EditText editTextRequest;
    private EditText editTextRoom;
    private Button buttonSubmit;
    private DatabaseHelperMaintenance databaseHelperMaintenance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_request);

        editTextRequest = findViewById(R.id.et_maintenance_issue);
        editTextRoom = findViewById(R.id.et_maintenance_room);
        buttonSubmit = findViewById(R.id.button_maintenance_submit);
        databaseHelperMaintenance = new DatabaseHelperMaintenance(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String request = editTextRequest.getText().toString().trim();
                String room = editTextRoom.getText().toString().trim();
                if (!request.isEmpty()) {
                    long result = databaseHelperMaintenance.insertMaintenanceRequest(request,room);
                    if (result > 0) {
                        Toast.makeText(MaintenanceRequestActivity.this, "Request submitted successfully", Toast.LENGTH_SHORT).show();
                        editTextRequest.setText("");
                    } else {
                        Toast.makeText(MaintenanceRequestActivity.this, "Failed to submit request", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MaintenanceRequestActivity.this, "Please enter a valid request", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
