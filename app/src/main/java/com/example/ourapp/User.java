package com.example.ourapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class User
{
    private int user_id;
    private String user_name;
    private String password;
    private String email;
    private String phone_number;

    public User(int user_id,String user_name,String password,String email,String phone_number){
        this.user_id=user_id;
        this.user_name=user_name;
        this.password=password;
        this.email=email;
        this.phone_number=phone_number;
    }

    public User() {

    }

    public int getUserID() {
        return user_id;
    }

    public void setUserID(int user_id) { this.user_id = user_id; }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) { this.user_name = user_name; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) { this.phone_number = phone_number; }


}

