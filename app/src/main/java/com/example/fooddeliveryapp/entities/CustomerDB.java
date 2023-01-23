package com.example.fooddeliveryapp.entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CustomerDB extends SQLiteOpenHelper {
    // constant variables for our db
    private static final String DB_NAME = "database";
    private static final String TABLE_NAME = "customer";
    private static final String ID_COL = "id";
    private static final String EMAIL_COL = "email";
    private static final String NAME_COL = "name";
    private static final String AGE_COL = "age";
    private static final String PASS_COL = "password";
    private static final int DB_VERSION = 1;

    // creating a constructor for our database handler.
    public CustomerDB (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating sqlite and setting column names along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EMAIL_COL + " TEXT,"
                + NAME_COL +  " TEXT,"
                + AGE_COL +  " TEXT,"
                + PASS_COL + " TEXT) ";

        // exec call to execute the query above.
        db.execSQL(query);
    }

    public void addNewCustomer (String name, String email, String age,  String pass) {
        SQLiteDatabase db = this.getWritableDatabase();

        // variable for content values.
        ContentValues values = new ContentValues();
        values.put(NAME_COL, name);
        values.put(EMAIL_COL, email);
        values.put(AGE_COL, age);
        values.put(PASS_COL, pass);
        // after adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null, values);
        // at last we are closing our database after adding database.
        // db.close();

    }

    public ArrayList<Customer> readCustomers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCustomers = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Customer> customerArrayList = new ArrayList<>();

        if (cursorCustomers.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                customerArrayList.add(new Customer(cursorCustomers.getString(1),
                        cursorCustomers.getString(2),
                        cursorCustomers.getString(3),
                        cursorCustomers.getString(4)));
            } while (cursorCustomers.moveToNext());
            // moving our cursor to next.
        }
        cursorCustomers.close();
        return customerArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // Creating a constant variables for Customer DB

}
