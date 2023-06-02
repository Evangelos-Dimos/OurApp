package com.example.ourapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText email;
    EditText phone_number;

    Button doneButton;

    Button backButton;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        doneButton = findViewById(R.id.doneButton);

        doneButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //registration(v);
                openActivity1();
            }
        });

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });
    }

    public void openActivity1()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**public void registration(View view)
    {
        UsersDBHandler dbHandler = new UsersDBHandler(this, null, null, 1);
        String  registerUsername= username.getText().toString();
        String registerPassword = password.getText().toString();
        String  registerEmail= email.getText().toString();
        String registerPhoneNumber = phone_number.getText().toString();

        if (!registerUsername.equals("") && !registerPassword.equals("") && !registerEmail.equals("") && !registerPhoneNumber.equals(""))
        {
            dbHandler.addUser(registerUsername,registerPassword,registerEmail,registerPhoneNumber);
            //openActivity3();
        }
        else{

        }
    }**/

}