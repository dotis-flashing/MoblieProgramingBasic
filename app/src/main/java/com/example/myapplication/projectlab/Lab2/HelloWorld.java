package com.example.myapplication.projectlab.Lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.projectlab.R;

public class HelloWorld extends Activity {
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helloworld);

        TextView textViewHello = findViewById(R.id.textViewHello);
        textViewHello.setText("Hello, " + getIntent().getStringExtra("username"));


        btnBack = findViewById(R.id.idBackhelloworld);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloWorld.this, Lab2Layoutexe03.class);
                startActivity(intent);
            }
        });
    }
}
