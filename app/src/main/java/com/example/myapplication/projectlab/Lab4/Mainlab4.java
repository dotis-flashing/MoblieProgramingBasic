package com.example.myapplication.projectlab.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.Lab3.Lab3Activity;
import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;
import java.util.List;

public class Mainlab4 extends AppCompatActivity {
    Button btnFood;
    Button btnDrink;
    Button btncBack;

    public static List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab4);

        ListView listView = findViewById(R.id.idorderlistlab4);


        Intent intent = getIntent();
        if (intent != null) {
            String giaTriNhanDuoc = intent.getStringExtra("key");

            // Sử dụng giá trị nhận được trong MainActivity
            if (giaTriNhanDuoc != null) {
                stringList.add(giaTriNhanDuoc);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.layoutlab4orderlist, R.id.idtextlab4listorder, stringList);
        listView.setAdapter(adapter);
        btnFood = findViewById(R.id.idbtnlab4food);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainlab4.this, FoodActivity.class);
                intent.putStringArrayListExtra("orderList", (ArrayList<String>) stringList);
                startActivity(intent);
            }
        });
        btnDrink = findViewById(R.id.idbtnlab4drink);
        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainlab4.this, DrinkActivity.class);
                intent.putStringArrayListExtra("orderList", (ArrayList<String>) stringList);
                startActivity(intent);
            }
        });
        btncBack = findViewById(R.id.idbacklab4main);
        btncBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainlab4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
