package com.example.myapplication.projectlab.Lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.Lab3.Exe01.Run;
import com.example.myapplication.projectlab.Lab3.Exe02.ListViewLanguage;
import com.example.myapplication.projectlab.Lab3.Exe03.RunPlayer;
import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

public class Lab3Activity extends MainActivity {
    Button layoutlab3exe01;
    Button layoutlab3exe02;
    Button layoutlab3exe03;
    Button idLab3ActivityBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylab3);
        layoutlab3exe01 = findViewById(R.id.idbtnlab3customerlistview);
        layoutlab3exe01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, Run.class);
                startActivity(intent);
            }
        });

        layoutlab3exe02 = findViewById(R.id.idbtnLab3ListViewLanguage);
        layoutlab3exe02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, ListViewLanguage.class);
                startActivity(intent);
            }
        });
        layoutlab3exe02 = findViewById(R.id.idListviewSoccer);
        layoutlab3exe02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, RunPlayer.class);
                startActivity(intent);
            }
        });
        idLab3ActivityBack = findViewById(R.id.idLab3ActivityBack);
        idLab3ActivityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
