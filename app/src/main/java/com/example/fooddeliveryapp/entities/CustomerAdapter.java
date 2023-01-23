package com.example.fooddeliveryapp.entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    private ArrayList<Customer> customerArrayList;
    private Context context;

    public CustomerAdapter() { }

    public CustomerAdapter(ArrayList<Customer> customerArrayList, Context context) {
        this.customerArrayList = customerArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customerdetails, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Customer modal = customerArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.email.setText(modal.getId());
        holder.age.setText(modal.getAge());
        holder.password.setText(modal.getPassword());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return customerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView name, email, age, password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            name = itemView.findViewById(R.id.customerName);
            email = itemView.findViewById(R.id.customerEmail);
            age = itemView.findViewById(R.id.Age);
            password = itemView.findViewById(R.id.password);
        }
    }
}
