package com.example.myapplication.projectlab.Lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.Lab1.Lab1Layout3;
import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

public class Lab2Activity extends Activity {
    Button btnBack;
    Button btnexe01;
    Button btnexe02;
    Button btnexe03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylab2);
        btnBack = findViewById(R.id.idlab2back2);
        btnexe01 = findViewById(R.id.idlab2exe01);
        btnexe02 = findViewById(R.id.idlab2exe02);
        btnexe03 = findViewById(R.id.idlab2exe03);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnexe01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Lab2Layoutexe01.class);
                startActivity(intent);
            }
        });
        btnexe02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Lab2Layoutexe02.class);
                startActivity(intent);
            }
        });
        btnexe03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Lab2Layoutexe03.class);
                startActivity(intent);
            }
        });
    }
}
