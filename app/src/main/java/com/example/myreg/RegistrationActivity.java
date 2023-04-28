package com.example.myreg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnLogin, btnregn;
    SharedPreferences preferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnregn = findViewById(R.id.regist);
        btnregn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences("UserInfo", 0);
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                if (usernameValue.length() > 1) {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.apply();
                    Intent loginScreen = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(loginScreen);
                    Toast.makeText(RegistrationActivity.this, "User signedin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Enter value in the field", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }
}