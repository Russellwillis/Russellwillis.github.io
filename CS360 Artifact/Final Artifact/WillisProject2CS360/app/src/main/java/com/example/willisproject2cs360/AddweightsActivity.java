package com.example.willisproject2cs360;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


public class AddweightsActivity extends AppCompatActivity {

    Button addWeight, back;
    String userName;
    EditText add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addweights);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
        }

        addWeight = findViewById(R.id.DeleteWeight);
        back = findViewById(R.id.BackToMain);
        add = findViewById(R.id.addWeight);

        addWeight.setOnClickListener(view-> {

            weightsDB db = new weightsDB(AddweightsActivity.this);
            db.addWeight(add.getText().toString().trim(), userName);
            Intent main = new Intent(this, WeightClass.class);
            main.putExtras(bundle);
            startActivity(main);

        });

        back.setOnClickListener((view -> {
            Intent main = new Intent(this, WeightClass.class);
            main.putExtras(bundle);
            startActivity(main);
        }));


    }







}