package com.example.trainsearch.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.trainsearch.bean.User;


public class myApplication extends Application {
    private SQLiteDatabase mdb;
    private User user;
    public SQLiteDatabase getMdb(){
        return mdb;
    }
    public void setMdb(SQLiteDatabase db){
        mdb=db;
    }
    public User getUser(){return user;}
    public void setUser(User usr){user=usr;}
}
