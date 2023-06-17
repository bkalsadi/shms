package com.example.shms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Get the "View Available Rooms" button
        Button viewRoomsButton = findViewById(R.id.button_view_rooms);
        viewRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ViewRoomsListActivity
                Intent intent = new Intent(HomePageActivity.this, ViewAvailableRoomsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonSubmitcomplaint = findViewById(R.id.button_complaints);
        buttonSubmitcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, SubmitComplaint.class);
                startActivity(intent);
            }
        });

        Button buttonMaintenanceRequest = findViewById(R.id.button_maintenance);
        buttonMaintenanceRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MaintenanceRequestActivity.class);
                startActivity(intent);
            }
        });

        Button buttonReserveRoom = findViewById(R.id.button_reserve_room);
        buttonReserveRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ReserveRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}