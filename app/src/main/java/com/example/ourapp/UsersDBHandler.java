package com.example.ourapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.example.ourapp.User;


public class UsersDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "usersDB.db";
    public static final String TABLE_USERS = "users";
    public static final int COLUMN_USER_ID = Integer.parseInt("user_id");
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";



    public UsersDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STORES_TABLE = "CREATE TABLE " +
                TABLE_USERS + "(" +
                COLUMN_USER_ID + " INTEGER PRIMARY KEY," +
                COLUMN_USER_NAME + " TEXT," +
                COLUMN_PASSWORD + " TEXT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_PHONE_NUMBER + " TEXT," +
                ")";
        db.execSQL(CREATE_STORES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public User findUser(String username, String password){
        String query= "SELECT * FROM " + TABLE_USERS + " WHERE "+
                COLUMN_USER_NAME + " = " + username + COLUMN_PASSWORD + " = " + password + "'";

        SQLiteDatabase db = this .getWritableDatabase();
        Cursor cursor = db.rawQuery(query , null);
        User user=new User();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            user.setUserID(Integer.parseInt(cursor.getString(0)));
            user.setUserName(cursor.getString(1));
            user.setPassword(String.valueOf(Integer.parseInt(cursor.getString(2))));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;

    }

    public void addUser(String username,String password,String email,String phone_number){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,username);
        values.put(COLUMN_PASSWORD,password);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_PHONE_NUMBER,phone_number);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS,null,values);
        db.close();
    }

}