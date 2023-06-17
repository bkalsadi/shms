package com.example.shms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperComplaint extends SQLiteOpenHelper {

    // Define the table name and column names
    private static final String TABLE_COMPLAINTS = "complaints";
    private static final String COLUMN_TITLE = "title";

    // Define the database name and version
    private static final String DATABASE_NAME = "complaints.db";
    private static final int DATABASE_VERSION = 1;


    // Constructor
    public DatabaseHelperComplaint(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Define the SQL statement for creating the complaints table
        String CREATE_TABLE_COMPLAINTS = "CREATE TABLE " +
                TABLE_COMPLAINTS + "(" +
                COLUMN_TITLE + " TEXT)";
        // Create the complaints table
        db.execSQL(CREATE_TABLE_COMPLAINTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists and create the new table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPLAINTS);
        onCreate(db);
    }

    // Insert a new complaint into the database
    public long insertComplaint(String title) {
        // Get a writable database
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object to store the complaint data
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);

        // Insert the data into the complaints table
        db.insert(TABLE_COMPLAINTS, null, values);

        // Close the database
        db.close();
        return 0;
    }
}

