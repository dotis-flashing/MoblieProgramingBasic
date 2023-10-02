package com.example.myapplication.projectlab.Lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.R;

public class Lab1LayoutInsta extends Activity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutinstagram);
        btnBack = findViewById(R.id.idbtnBackInsta);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1LayoutInsta.this,Lab1Activity.class);
                startActivity(intent);
            }
        });
    }
}
