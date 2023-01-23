package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fooddeliveryapp.entities.Customer;
import com.example.fooddeliveryapp.entities.CustomerAdapter;
import com.example.fooddeliveryapp.entities.CustomerDB;

import java.util.ArrayList;

public class customerView extends AppCompatActivity {

    // dbhandler, adapter and recycler view.
    private ArrayList<Customer> custArrayList;
    private CustomerDB dbHandler;
    private CustomerAdapter custRVAdapter;
    private RecyclerView customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);

        custArrayList = new ArrayList<>();
        dbHandler = new CustomerDB(customerView.this);
        custArrayList = dbHandler.readCustomers();

        // on below line passing our array lost to our adapter class.
        custRVAdapter = new CustomerAdapter(custArrayList, customerView.this);
        customers = findViewById(R.id.customers1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(customerView.this, RecyclerView.VERTICAL, false);

        customers.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        customers.setAdapter(custRVAdapter);
    }
}