package com.example.willisproject2cs360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class WeightClass extends AppCompatActivity {
    String userName;

    Button settings, addButton, deleteButton;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    weightsDB db;
    ArrayList<String> weightsID, weights;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_class);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
        }
        recyclerView = findViewById(R.id.rv);
        settings = findViewById(R.id.settings);
        addButton = findViewById(R.id.add);
        deleteButton = findViewById(R.id.DeleteItem);
        db = new weightsDB(WeightClass.this);
        weightsID = new ArrayList<>();
        weights = new ArrayList<>();

        displayData();
        customAdapter = new CustomAdapter(WeightClass.this,weightsID,weights, deleteButton, userName, db );
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(WeightClass.this));

        settings.setOnClickListener(view -> {
            Intent settings = new Intent(this, SettingsClass.class);
            settings.putExtras(bundle);
            startActivity(settings);
        });
        addButton.setOnClickListener(view -> {
            Intent add = new Intent(this, AddweightsActivity.class);
            add.putExtras(bundle);
            startActivity(add);
        });


    }

    void displayData() {


      Cursor cursor = db.readWeightsByUser(userName);

        if (cursor == null || cursor.getCount() == 0) {
            Toast.makeText(this, "No weights found for user " + userName, Toast.LENGTH_SHORT).show();
        } else {
            cursor.moveToFirst(); // Move to the first row
            while (!cursor.isAfterLast()) {
                weightsID.add(cursor.getString(0));
                weights.add(cursor.getString(1));
                cursor.moveToNext(); // Move to the next row
            }
            cursor.close(); // Close the cursor to free up resources
        }
    }
}
