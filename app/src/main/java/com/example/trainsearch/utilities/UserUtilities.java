package com.example.trainsearch.utilities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.trainsearch.bean.User;
import com.example.trainsearch.data.UserContract;


public class UserUtilities {
    public static boolean check(String userid,String pwd,SQLiteDatabase db){
        if(db == null){
            return false;
        }
        String selection=UserContract.UserListEntry.COLUMN_USER_ID+" = ? AND "+ UserContract.UserListEntry.COLUMN_PWD+" = ?";
        String[] selectionArgs=new String[]{userid,pwd};
        Cursor cursor=db.query(
                UserContract.UserListEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        if(cursor.getCount()==0){
            return false;
        }
        else{
            return true;
        }
    }
    public static User getUser(String userid,String pwd,SQLiteDatabase db){
        if(db == null){
            return null;
        }
        String selection=UserContract.UserListEntry.COLUMN_USER_ID+" = ? AND "+ UserContract.UserListEntry.COLUMN_PWD+" = ?";
        String[] selectionArgs=new String[]{userid,pwd};
        Cursor cursor=db.query(
                UserContract.UserListEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        if(cursor.getCount()==1&&cursor.moveToFirst()){
            int _id= Integer.parseInt(cursor.getString(cursor.getColumnIndex(UserContract.UserListEntry._ID)));
            String username=cursor.getString(cursor.getColumnIndex(UserContract.UserListEntry.COLUMN_USER_NAME));
            String licensetype=cursor.getString(cursor.getColumnIndex(UserContract.UserListEntry.COLUMN_LICENSE_TYPE));
            String licensenumber=cursor.getString(cursor.getColumnIndex(UserContract.UserListEntry.COLUMN_LICENSE_NUMBER));
            String passengertype=cursor.getString(cursor.getColumnIndex(UserContract.UserListEntry.COLUMN_PASSENGER_TYPE));
            String phonenumber=cursor.getString(cursor.getColumnIndex(UserContract.UserListEntry.COLUMN_PHONE_NUMBER));
            return new User(_id,userid,pwd,username,licensetype,licensenumber,passengertype,phonenumber);
        }
        else{
            return null;
        }
    }
    public static  boolean updateUser(User user,SQLiteDatabase db){
        if(db == null){
            return false;
        }

        String userName=user.getUsername();
        String licenseType=user.getLicensetype();
        String licenseNumber=user.getLicensenumber();
        String passengerType=user.getPassengertype();
        String phoneNumber=user.getPhonenumber();

        ContentValues cv = new ContentValues();
        cv.put(UserContract.UserListEntry.COLUMN_USER_NAME, userName);
        cv.put(UserContract.UserListEntry.COLUMN_LICENSE_TYPE,licenseType);
        cv.put(UserContract.UserListEntry.COLUMN_LICENSE_NUMBER,licenseNumber);
        cv.put(UserContract.UserListEntry.COLUMN_PASSENGER_TYPE,passengerType);
        cv.put(UserContract.UserListEntry.COLUMN_PHONE_NUMBER,phoneNumber);

        db.update(
                UserContract.UserListEntry.TABLE_NAME,
                cv,
                UserContract.UserListEntry._ID+"=?",
                new String[]{String.valueOf(user.get_id())}
        );
        return true;
    }
    public static boolean insertUser(User user,SQLiteDatabase  db){
        if(db == null){
            return false;
        }
        String userId=user.getUserid();
        String pwd=user.getPwd();
        String userName=user.getUsername();
        String licenseType=user.getLicensetype();
        String licenseNumber=user.getLicensenumber();
        String passengerType=user.getPassengertype();
        String phoneNumber=user.getPhonenumber();

        ContentValues cv=new ContentValues();
        cv.put(UserContract.UserListEntry.COLUMN_USER_ID,userId);
        cv.put(UserContract.UserListEntry.COLUMN_PWD,pwd);
        cv.put(UserContract.UserListEntry.COLUMN_USER_NAME,userName);
        cv.put(UserContract.UserListEntry.COLUMN_LICENSE_TYPE,licenseType);
        cv.put(UserContract.UserListEntry.COLUMN_LICENSE_NUMBER,licenseNumber);
        cv.put(UserContract.UserListEntry.COLUMN_PASSENGER_TYPE,passengerType);
        cv.put(UserContract.UserListEntry.COLUMN_PHONE_NUMBER,phoneNumber);



        db.insert(
                UserContract.UserListEntry.TABLE_NAME,
                null,
                cv
        );
        return true;
    }
    public static boolean checkUserIfExist(User user,SQLiteDatabase db){
        if(db == null){
            return false;
        }
        String userid=user.getUserid();

        String selection=UserContract.UserListEntry.COLUMN_USER_ID+" = ?";
        String[] selectionArgs=new String[]{userid};
        Cursor cursor=db.query(
                UserContract.UserListEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
                null);
        if(cursor.getCount()==0){
            return false;
        }
        else{
            return true;
        }
    }
}
