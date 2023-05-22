package com.example.ourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText email;
    EditText phone_number;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void registration(View view)
    {
        UsersDBHandler dbHandler = new UsersDBHandler(this, null, null, 1);
        String  registerUsername= username.getText().toString();
        String registerPassword = password.getText().toString();
        String  registerEmail= email.getText().toString();
        String registerPhoneNumber = phone_number.getText().toString();

        if (!registerUsername.equals("") && !registerPassword.equals("") && !registerEmail.equals("") && !registerPhoneNumber.equals(""))
        {
            dbHandler.addUser(registerUsername,registerPassword,registerEmail,registerPhoneNumber);
            // pigaine sto x activity
        }
    }

}