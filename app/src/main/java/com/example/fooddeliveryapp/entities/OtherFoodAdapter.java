package com.example.fooddeliveryapp.entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;

import java.util.List;

public class OtherFoodAdapter extends RecyclerView.Adapter<OtherFoodAdapter.OtherFoodViewHolder> {
    Context context;
    List<OtherFood> otherFoodsList;

    public OtherFoodAdapter (Context contextm, List<OtherFood> otherFoodsList) {
        this.context = contextm;
        this.otherFoodsList = otherFoodsList;
    }

    @NonNull
    @Override
    public OtherFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.other_food_items,parent,false);
        return new OtherFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherFoodViewHolder holder, int position) {
        holder.foodImage1.setImageResource(otherFoodsList.get(position).getImageUrl());
        holder.name1.setText(otherFoodsList.get(position).getName());
        holder.price1.setText(otherFoodsList.get(position).getPrice());
        holder.rating.setText(otherFoodsList.get(position).getRating());
        holder.restaurantName.setText(otherFoodsList.get(position).getRestarauntName());

    }

    @Override
    public int getItemCount() {
        return otherFoodsList.size();
    }

    public static final class  OtherFoodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage1;
        TextView name1, price1, rating, restaurantName;

        public OtherFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage1 = itemView.findViewById(R.id.food_img1);
            price1 = itemView.findViewById(R.id.price_item1);
            name1 = itemView.findViewById(R.id.item_name1);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            rating = itemView.findViewById(R.id.rating);

        }
    }
}
