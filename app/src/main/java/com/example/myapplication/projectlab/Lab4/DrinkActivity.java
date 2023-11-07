package com.example.myapplication.projectlab.Lab4;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.R;

import java.util.ArrayList;
import java.util.List;


public class DrinkActivity extends AppCompatActivity {
    private static int CURRENT_POST = -1;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab4drink);
        ListView listFood = findViewById(R.id.idlistviewLab4ListDrink);
        EditText editFood = findViewById(R.id.idtxtlab4drink);
        Button btnOrder = findViewById(R.id.idbtnOrderLab4Drink);

        btnBack = findViewById(R.id.idbtnExitlab4drink);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinkActivity.this, Mainlab4.class);
                startActivity(intent);
            }
        });
        List<String> stringList = new ArrayList<>();
        stringList.add("Pepsi");
        stringList.add("Heineken");
        stringList.add("Tiger");
        stringList.add("Sài gòn Đỏ");
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.layoutlab4drinklist, R.id.idtextlab4drinklist, stringList);
        listFood.setAdapter(adapter);
        listFood.setOnItemClickListener((parent, view, position, id) -> {
            editFood.setText(stringList.get(position));
            CURRENT_POST = position;
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chooseFood = editFood.getText().toString().trim();
                if (chooseFood.isEmpty()) {
                    editFood.setError("Vui chọn món ăn!");
                    editFood.requestFocus();
                }
                else{

                    Intent intent = new Intent(DrinkActivity.this, Mainlab4.class);
                    intent.putExtra("key", chooseFood);
                    stringList.add(chooseFood);
                    startActivity(intent);
                }
            }
        });
    }
}
