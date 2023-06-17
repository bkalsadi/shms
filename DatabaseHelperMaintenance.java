package com.example.shms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperMaintenance extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "maintenance.db";
    private static final int DATABASE_VERSION = 2;


    private static final String TABLE_MAINTENANCE_REQUESTS = "maintenance_requests";
    private static final String COL_REQUEST_ID = "id";
    private static final String COL_ROOMNO = "room";
    private static final String COL_REQUEST = "request";

    public DatabaseHelperMaintenance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createMaintenanceRequestsTable = "CREATE TABLE " + TABLE_MAINTENANCE_REQUESTS +
                "(" + COL_REQUEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ROOMNO + " TEXT, " +
                COL_REQUEST + " TEXT)";
        db.execSQL(createMaintenanceRequestsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAINTENANCE_REQUESTS);
        onCreate(db);
    }

    public long insertMaintenanceRequest(String maintenance, String room) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_REQUEST, maintenance);
        contentValues.put(COL_ROOMNO, room);
        long result = db.insert(TABLE_MAINTENANCE_REQUESTS, null, contentValues);
        db.close();
        return result;
    }
}


