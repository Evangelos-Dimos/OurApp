package com.example.ourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234"))
            {
                Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            } else
            {
                Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void signIn(View view)
    {
        UsersDBHandler dbHandler = new UsersDBHandler(this, null, null, 1);
        String  signInUsername= username.getText().toString();
        String signInPassword = password.getText().toString();
        if (!signInUsername.equals("") && !signInPassword.equals(""))
        {
            User found = dbHandler.findUser(signInUsername,signInPassword);
            if (found!=null)
            {
                //πήγαινε στο 3ο activity
            }
        }

    }

    public void register(View view)
    {
        //πήγαινε στο 2ο activity
    }


}