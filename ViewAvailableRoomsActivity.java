package com.example.shms;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewAvailableRoomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_rooms);

        // Get a reference to the ListView
        ListView listView = findViewById(R.id.list_view_rooms);

        // Create a list of available rooms
        List<String> rooms = new ArrayList<>();
        rooms.add("Room 101 - Single");
        rooms.add("Room 102 - Single");
        rooms.add("Room 103 - Single");
        rooms.add("Room 104 - Single");
        rooms.add("Room 105 - Single");
        rooms.add("Room 201 - Two Bed");
        rooms.add("Room 202 - Two Bed");
        rooms.add("Room 203 - Two Bed");
        rooms.add("Room 204 - Two Bed");
        rooms.add("Room 205 - Two Bed");
        rooms.add("Room 301 - Three Bed");
        rooms.add("Room 302 - Three Bed");
        rooms.add("Room 303 - Three Bed");
        rooms.add("Room 304 - Three Bed");
        rooms.add("Room 305 - Three Bed");

        // Create an ArrayAdapter for the list of rooms
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rooms);

        // Set the ArrayAdapter on the ListView
        listView.setAdapter(adapter);
    }
}

