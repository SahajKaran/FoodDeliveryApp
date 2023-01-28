package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fooddeliveryapp.entities.Customer;
import com.example.fooddeliveryapp.entities.CustomerAdapter;
import com.example.fooddeliveryapp.entities.CustomerDB;

import java.util.ArrayList;

public class logReg extends AppCompatActivity {
    // Variables
    private EditText emailEdt, passwordEdt;
    private ArrayList<Customer> custArrayList;
    private CustomerDB dbHandler;
    private int customerListSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);

        // Text Fields
        emailEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);

        // Buttons
        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);
        Button accounts = findViewById(R.id.accounts);

        showHidePass();


        // Request permissions to store data.
        String[] permissionsStorage = {Manifest.permission.READ_EXTERNAL_STORAGE};
        int requestExternalStorage = 1;
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissionsStorage, requestExternalStorage);
        }

        //Get customer data if customer registered let them login.
        custArrayList = new ArrayList<>();
        dbHandler = new CustomerDB(logReg.this);
        custArrayList = dbHandler.readCustomers();
        customerListSize = custArrayList.size();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validUser = false;
                String userEmail = emailEdt.getText().toString();
                String passWord = passwordEdt.getText().toString();
                String dbUser;
                String dbUserPass;

                //Remove this part.
                Intent intent1 = new Intent(logReg.this, MainActivity.class);
                startActivity(intent1);

//                if (userEmail.isEmpty() || passWord.isEmpty()) {
//                    Toast.makeText(logReg.this, "Please fill email and password fields.", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                //Search Database for customer
//                //ToDO: Optimize for loop Binary search maybe ?
//                for (int i = 0; i<customerListSize; i++) {
//
//                    dbUser = custArrayList.get(i).getId();
//                    dbUserPass = custArrayList.get(i).getPassword();
//                    if (userEmail.equals(dbUser) && passWord.equals(dbUserPass)) {
//                        validUser = true; //customer was found on the database.
//                    }
//                }
//
//                if (validUser) { // Customer is valid user let them through to main page.
//                    Intent intent = new Intent(logReg.this, MainActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(logReg.this, "Ivalid User. Please Register.", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(logReg.this, registrationPage.class);
                startActivity(intent);
            }
        });

        accounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(logReg.this, customerView.class);
                startActivity(i);
            }
        });

    }

    private void showHidePass () {
        //Show Hide Password
        ImageView showHidePwd = findViewById(R.id.imageView_shows_hide_pwd);
        showHidePwd.setImageResource(R.drawable.ic_hide_pwd);
        showHidePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordEdt.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    //if password is visible hide
                    passwordEdt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    showHidePwd.setImageResource(R.drawable.ic_hide_pwd);
                } else {
                    passwordEdt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showHidePwd.setImageResource(R.drawable.ic_show_pwd);
                }
            }
        });
    }


}