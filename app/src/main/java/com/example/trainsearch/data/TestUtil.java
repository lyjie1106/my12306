package com.example.trainsearch.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static void insertFakeData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(UserContract.UserListEntry.COLUMN_USER_ID,"root");
        cv.put(UserContract.UserListEntry.COLUMN_PWD,"123");
        cv.put(UserContract.UserListEntry.COLUMN_USER_NAME,"lujie");
        cv.put(UserContract.UserListEntry.COLUMN_LICENSE_TYPE,"身份证");
        cv.put(UserContract.UserListEntry.COLUMN_LICENSE_NUMBER,"123123123");
        cv.put(UserContract.UserListEntry.COLUMN_PASSENGER_TYPE,"学生");
        cv.put(UserContract.UserListEntry.COLUMN_PHONE_NUMBER,"17609839606");
        list.add(cv);



        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (UserContract.UserListEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(UserContract.UserListEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }

    }
}
