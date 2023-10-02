package com.example.myapplication.projectlab.Lab3.Exe01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.Lab3.Exe02.ListViewLanguage;
import com.example.myapplication.projectlab.Lab3.Lab3Activity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;

public class Run extends AppCompatActivity {
    ListView listView;
    ArrayList<TraiCay> traiCays;
    TraiCayAdapt adapt;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab3exe01);
        AnhXa();
        adapt = new TraiCayAdapt(this, R.layout.layoutlab3exe012, traiCays);
        listView.setAdapter(adapt);

        btnBack = findViewById(R.id.idbtnlab3exe01Back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Run.this, Lab3Activity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        listView = findViewById(R.id.idlab3listview);
        traiCays = new ArrayList<>();
        traiCays.add(new TraiCay("Anh đào", "(Cherry)", R.drawable.anhdao));
        traiCays.add(new TraiCay("Bình bát", "Annona reticulata", R.drawable.binhbat));
        traiCays.add(new TraiCay("Bòn bon", "Lansium domesticum Hiern", R.drawable.bonbon));
        traiCays.add(new TraiCay("Bơ", "Persea americana Mill", R.drawable.bo));
        traiCays.add(new TraiCay("Bưởi", "Bưởi Citrus grandis", R.drawable.buoi));

    }
}
