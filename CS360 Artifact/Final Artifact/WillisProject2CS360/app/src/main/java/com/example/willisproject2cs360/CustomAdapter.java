package com.example.willisproject2cs360;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    weightsDB db;
    Button deleteButton;
    String userName;
    ArrayList weightID, weights;
    CustomAdapter(Context context, ArrayList weightID, ArrayList weights, Button deleteButton, String userName, weightsDB db){
        this.context = context;
        this.weightID = weightID;
        this.weights = weights;
        this.deleteButton = deleteButton;
        this.userName = userName;
        this.db = db;

    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.weightID.setText(String.valueOf(weightID.get(position)));
        holder.weights.setText(String.valueOf(weights.get(position)));

        holder.deleteButton.setOnClickListener(view ->{
            db.deleteItem(String.valueOf(weightID.get(position)),userName);
            weightID.remove(position);
            weights.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return weightID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView weightID, weights;
        Button deleteButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            weightID = itemView.findViewById(R.id.WeightIdText);
            weights = itemView.findViewById(R.id.WeightText);
            deleteButton = itemView.findViewById(R.id.DeleteItem);
        }
    }
}
