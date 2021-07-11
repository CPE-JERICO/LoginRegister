package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class mainapp extends AppCompatActivity {

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapp);

        t1 = findViewById(R.id.user);

        String username = getSharedPreferences("username", MODE_PRIVATE).getString("uname", "");
        t1.setText(username);

    }
}