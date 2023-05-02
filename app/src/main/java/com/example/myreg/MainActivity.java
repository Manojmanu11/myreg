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

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private Button btnLogin,btnregn;
    SharedPreferences preferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbuttton);
        btnregn =  findViewById(R.id.regist);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String usernameValue=username.getText().toString();
                String passwordValue=password.getText().toString();
                String signupUsername=preferences.getString("username","");
                String signupPassword=preferences.getString("password","");
                if(usernameValue.equals(signupUsername)&&passwordValue.equals(signupPassword)){
                    Intent intent1=new Intent(MainActivity.this,Homeactivity.class);
                    startActivity(intent1);
                }
            }
        });
        btnregn =  findViewById(R.id.regist);
        btnregn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
