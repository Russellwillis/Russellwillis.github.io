package com.example.willisproject2cs360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsClass extends AppCompatActivity {
    Button Back;
    Button SignOut;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
        }

        setContentView(R.layout.activity_settings);
        Back = findViewById(R.id.Back);
        SignOut = findViewById(R.id.SignOut);

        Back.setOnClickListener(View ->{
                Intent changeScreen = new Intent(this, WeightClass.class);
                changeScreen.putExtras(bundle);
                startActivity(changeScreen);
        });

        SignOut.setOnClickListener(View ->{
                Intent signOut = new Intent(this, MainActivity.class);
                startActivity(signOut);
        });

    }

}