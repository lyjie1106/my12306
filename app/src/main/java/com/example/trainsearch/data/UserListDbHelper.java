package com.example.trainsearch.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserListDbHelper extends SQLiteOpenHelper {
    // The database name
    private static final String DATABASE_NAME = "trainsearch.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 2;

    // Constructor
    public UserListDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + UserContract.UserListEntry.TABLE_NAME + " (" +
                UserContract.UserListEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                UserContract.UserListEntry.COLUMN_USER_ID+" TEXT NOT NULL,"+
                UserContract.UserListEntry.COLUMN_PWD+" TEXT NOT NULL,"+
                UserContract.UserListEntry.COLUMN_USER_NAME+" TEXT NOT NULL,"+
                UserContract.UserListEntry.COLUMN_LICENSE_TYPE+" TEXT NOT NULL,"+
                UserContract.UserListEntry.COLUMN_LICENSE_NUMBER+" TEXT NOT NULL,"+
                UserContract.UserListEntry.COLUMN_PASSENGER_TYPE+" TEXT NOT NULL,"+
                UserContract.UserListEntry.COLUMN_PHONE_NUMBER+" TEXT NOT NULL"+");";
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserContract.UserListEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
