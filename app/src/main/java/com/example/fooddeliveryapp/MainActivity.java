package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fooddeliveryapp.entities.PopularFood;
import com.example.fooddeliveryapp.entities.PopularFoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView popularRecycler;
    PopularFoodAdapter popularFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hardcoded Products. Implement dynamic later
        List<PopularFood> popularFoodList = new ArrayList<>();
        popularFoodList.add(new PopularFood("Float Cake", "12$", R.drawable.popularfood1));
        popularFoodList.add(new PopularFood("Chicken Wings", "22$", R.drawable.popularfood2));
        popularFoodList.add(new PopularFood("Fish", "17$", R.drawable.popularfood3));

        setPopularRecycler(popularFoodList);

    }

    private void setPopularRecycler(List<PopularFood> popularFoodList) {
        popularRecycler = findViewById(R.id.food_items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularFoodAdapter = new PopularFoodAdapter(this,popularFoodList);
        popularRecycler.setAdapter(popularFoodAdapter);
    }
}