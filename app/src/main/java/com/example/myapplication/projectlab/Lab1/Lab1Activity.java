package com.example.myapplication.projectlab.Lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

public class Lab1Activity extends Activity {
    Button btnBack;
    Button btnlayout1;
    Button btnlayout2;
    Button btnlayout3;
    Button btnlayoutFaceBook;
    Button btnlayoutInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylab1);
        btnBack = findViewById(R.id.idbtnback1);
        btnlayout1 = findViewById(R.id.idlab1layout1);
        btnlayout3 = findViewById(R.id.idlab1layout3);
        btnlayoutFaceBook = findViewById(R.id.idbtnlayoutfacebook);
        btnlayoutInstagram = findViewById(R.id.idbtnlayoutinstagram);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Lab1Layout1.class);
                startActivity(intent);
            }
        });
        btnlayout2 = findViewById(R.id.idlab1layout2);
        btnlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Lab1Layout2.class);
                startActivity(intent);
            }
        });
        btnlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Lab1Layout3.class);
                startActivity(intent);
            }
        });
        btnlayoutFaceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Lab1LayoutFb.class);
                startActivity(intent);
            }
        });
        btnlayoutInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Lab1LayoutInsta.class);
                startActivity(intent);
            }
        });
    }
}
