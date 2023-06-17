package com.example.shms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Rooms.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ROOMS = "rooms";
    private static final String COL_ROOM_ID = "room_id";
    private static final String COL_ROOM_NUMBER = "room_number";
    private static final String COL_AVAILABILITY = "availability";

    private static final String CREATE_TABLE_ROOMS = "CREATE TABLE " + TABLE_ROOMS + "("
            + COL_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ROOM_NUMBER + " TEXT, "
            + COL_AVAILABILITY + " INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ROOMS);

        // Populate initial room data
        insertRoom(db, "101");
        insertRoom(db, "102");
        insertRoom(db, "103");
        insertRoom(db, "104");
        insertRoom(db, "105");
        insertRoom(db, "201");
        insertRoom(db, "202");
        insertRoom(db, "203");
        insertRoom(db, "204");
        insertRoom(db, "205");
        insertRoom(db, "301");
        insertRoom(db, "302");
        insertRoom(db, "303");
        insertRoom(db, "304");
        insertRoom(db, "305");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        onCreate(db);
    }

    public long insertRoom(SQLiteDatabase db, String roomNumber) {
        ContentValues values = new ContentValues();
        values.put(COL_ROOM_NUMBER, roomNumber);
        values.put(COL_AVAILABILITY, 1);

        return db.insert(TABLE_ROOMS, null, values);
    }

    public boolean updateRoomAvailability(String roomNumber) {
        ContentValues values = new ContentValues();
        values.put(COL_AVAILABILITY, 0);
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsAffected = db.update(TABLE_ROOMS, values, COL_ROOM_NUMBER + " = ?", new String[]{roomNumber});

        return rowsAffected > 0;
    }

    public int getAvailableRooms(String roomNo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ROOMS, new String[]{COL_AVAILABILITY}, COL_ROOM_NUMBER + " = ?", new String[]{roomNo}, null, null, null);
        int availability = 0;
        if (cursor.moveToFirst()) {
            availability = cursor.getInt(cursor.getColumnIndex(COL_AVAILABILITY));
        }
        cursor.close();
        return availability;
    }

}
