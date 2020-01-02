package com.example.trainsearch.data;

import android.provider.BaseColumns;

public class UserContract {
    public static final class UserListEntry implements BaseColumns {
        public static final String TABLE_NAME = "userlist";
        public static final String COLUMN_USER_ID="userid";
        public static final String COLUMN_PWD="pwd";
        public static final String COLUMN_USER_NAME="username";
        public static final String COLUMN_LICENSE_TYPE="licensetype";
        public static final String COLUMN_LICENSE_NUMBER="licensenumber";
        public static final String COLUMN_PASSENGER_TYPE="passengertype";
        public static final String COLUMN_PHONE_NUMBER="phonenumber";
    }
}
