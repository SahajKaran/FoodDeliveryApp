package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fooddeliveryapp.entities.CustomerDB;

public class registrationPage extends AppCompatActivity {

    private EditText nameEdt, ageEdt, emailEdt, passwordEdt;
    private Button register;
    private CustomerDB dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        // initialize variables;
        nameEdt = findViewById(R.id.name);
        ageEdt = findViewById(R.id.age);
        emailEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);
        register = findViewById(R.id.register);

        // create database class and pass context to it.
        dbHandler = new CustomerDB(registrationPage.this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nameEdt.getText().toString();
                String age = ageEdt.getText().toString();
                String email = emailEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (username.isEmpty() && age.isEmpty() && email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(registrationPage.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewCustomer (username,email,age,password);

                Toast.makeText(registrationPage.this, "Account has been created.", Toast.LENGTH_SHORT).show();

                // Customer is done registering move to login page.
                new Handler().postDelayed(() -> {
                    Intent i = new Intent(registrationPage.this, logReg.class);
                    startActivity(i);
                    finish();
                }, 3000);
            }
        });

    }


}