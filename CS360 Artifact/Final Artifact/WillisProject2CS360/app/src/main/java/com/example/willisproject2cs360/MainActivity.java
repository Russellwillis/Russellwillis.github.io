package com.example.willisproject2cs360;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    Button signInButton, SignUpButton;
    EditText UserNameInput, PasswordInput;
    String userName;
    SQLiteDatabase db;
    UserDB users;
    Activity activity;
    String F_Result = "Not_Found";
    String password = "NOT_FOUND" ;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        signInButton = findViewById(R.id.SignInButton);
        SignUpButton = findViewById(R.id.SignUpButton);
        UserNameInput = findViewById(R.id.UsernameInput);
        PasswordInput = findViewById(R.id.PasswordInput);
        users = new UserDB(this);

        signInButton.setOnClickListener(view -> {login();});
        SignUpButton.setOnClickListener(view -> {register();});

        userName = UserNameInput.getText().toString().trim();
    }

    private void register()
    {
        if(!UserNameInput.getText().toString().trim().isEmpty()) {
            CheckUserName();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Username or Password field is blank ",Toast.LENGTH_SHORT).show();
        }
    }

    private void CheckUserName()
    {
        userName = UserNameInput.getText().toString().trim();
        db = users.getWritableDatabase();
        Cursor cursor = db.query(UserDB.TABLE_NAME, null, " " + UserDB.COLUMN_1_USERNAME + "=?", new String[]{userName}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                F_Result = "Username Found";
                cursor.close();
            }
        }
        users.close();
        usernameFound();

    }

    private void usernameFound()
    {
        if(F_Result.equalsIgnoreCase("Username Found"))
        {
            Toast.makeText(MainActivity.this,"Username Already Exists",Toast.LENGTH_LONG).show();
        }
        else {
            InsertUserIntoDatabase();
        }
        F_Result = "Not_Found" ;
    }

    private void InsertUserIntoDatabase()
    {
        User user = new User(userName,PasswordInput.getText().toString().trim());
        users.createUser(user);
        Toast.makeText(MainActivity.this,"User Registered", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        this.finish();
    }

    @SuppressLint("Range")
    private void login()
    {
        if (!UserNameInput.getText().toString().trim().isEmpty()) {
            db = users.getWritableDatabase();

            String[] selectionArgs = {UserNameInput.getText().toString().trim()};
            Cursor cursor = db.query(UserDB.TABLE_NAME, null, UserDB.COLUMN_1_USERNAME + " = ?", selectionArgs, null, null, null);

            try {
                if (cursor.moveToFirst()) {
                    password = cursor.getString(cursor.getColumnIndex(UserDB.COLUMN_2_PASSWORD));
                }
            } finally {
                cursor.close();
            }

            users.close();
            checkResults();
        } else {
            Toast.makeText(MainActivity.this, "Username Blank", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkResults()
    {
        if (password != null && password.equalsIgnoreCase(PasswordInput.getText().toString().trim())) {
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putString("userName", UserNameInput.getText().toString().trim());
            Intent intent = new Intent(MainActivity.this, WeightClass.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Incorrect Username or Password\nor User Not Registered", Toast.LENGTH_LONG).show();
        }
    }


}