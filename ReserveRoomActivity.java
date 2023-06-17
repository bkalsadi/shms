package com.example.shms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ReserveRoomActivity extends AppCompatActivity {

    private Spinner spinnerRooms;
    private Button buttonReserve;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_room);

        spinnerRooms = findViewById(R.id.spinner_rooms);
        buttonReserve = findViewById(R.id.button_reserve);

        // Create database helper instance
        databaseHelper = new DatabaseHelper(this);

        // Populate spinner with pre-defined room numbers
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rooms_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRooms.setAdapter(adapter);

        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedRoom = spinnerRooms.getSelectedItem().toString();

                // Check if the room is available
                if (databaseHelper.getAvailableRooms(selectedRoom) == 0) {
                    Toast.makeText(ReserveRoomActivity.this, "Room " + selectedRoom + " is already booked", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Update the room availability in the database
                if (databaseHelper.updateRoomAvailability(selectedRoom)) {
                    Toast.makeText(ReserveRoomActivity.this, "Room " + selectedRoom + " reserved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReserveRoomActivity.this, "Failed to reserve room " + selectedRoom, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
