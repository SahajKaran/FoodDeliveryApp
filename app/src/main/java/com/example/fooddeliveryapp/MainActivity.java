package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fooddeliveryapp.entities.OtherFood;
import com.example.fooddeliveryapp.entities.OtherFoodAdapter;
import com.example.fooddeliveryapp.entities.PopularFood;
import com.example.fooddeliveryapp.entities.PopularFoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView popularRecycler;
    PopularFoodAdapter popularFoodAdapter;

    RecyclerView otherFoodRecycler;
    OtherFoodAdapter otherFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hardcoded Products. Implement dynamic later
        List<PopularFood> popularFoodList = new ArrayList<>();
        popularFoodList.add(new PopularFood("Float Cake 250g", "12$", R.drawable.popularfood1));
        popularFoodList.add(new PopularFood("Chicken Wings", "22$", R.drawable.popularfood2));
        popularFoodList.add(new PopularFood("Fish Sticks 200g", "17$", R.drawable.popularfood3));
        setPopularRecycler(popularFoodList);

        List<OtherFood> otherFoodsList = new ArrayList<>();
        otherFoodsList.add(new OtherFood("Pepperoni Pizza", "19$", R.drawable.asiafood1,"4.6","FirePizza"));
        otherFoodsList.add(new OtherFood("Strawberry Cake", "6$", R.drawable.asiafood2, "3.9","Chefs Kitchen"));
        setOtherFoodRecycler(otherFoodsList);
    }

    private void setPopularRecycler(List<PopularFood> popularFoodList) {
        popularRecycler = findViewById(R.id.food_items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this,popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);
    }

    private void setOtherFoodRecycler(List<OtherFood> otherFoodsList) {
        otherFoodRecycler = findViewById(R.id.food_items2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        otherFoodRecycler.setLayoutManager(layoutManager2);
        otherFoodAdapter = new OtherFoodAdapter(this,otherFoodsList);
        otherFoodRecycler.setAdapter(otherFoodAdapter);
    }
}