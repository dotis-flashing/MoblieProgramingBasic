package com.example.myapplication.projectlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.Lab1.Lab1Activity;
import com.example.myapplication.projectlab.Lab2.Lab2Activity;
import com.example.myapplication.projectlab.Lab3.Lab3Activity;

public class MainActivity extends AppCompatActivity {
Button btnLab1;
Button btnLab2;
Button btnLab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLab1= findViewById(R.id.idbtnLab1);

        btnLab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab1Activity.class);
                startActivity(intent);
            }
        });
        btnLab2 = findViewById(R.id.idbtnLab2);
        btnLab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab2Activity.class);
                startActivity(intent);
            }
        });
        btnLab3 = findViewById(R.id.idlab3);
        btnLab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lab3Activity.class);
                startActivity(intent);
            }
        });
    }
}