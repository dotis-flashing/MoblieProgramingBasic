package com.example.myapplication.projectlab.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private static int CURRENT_POST = -1;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab4food);

        ListView listFood = findViewById(R.id.idlab4ListFood);
        EditText editFood = findViewById(R.id.editfoodIdlab4);
        Button btnOrder = findViewById(R.id.idbtnOrderfood);

        btnBack = findViewById(R.id.idbtnLab4Exitfood);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodActivity.this, Mainlab4.class);
                startActivity(intent);
            }
        });
        List<String> stringList = new ArrayList<>();

        stringList.add("Phở Hà Nội");
        stringList.add("Bún Bò Huế");
        stringList.add("Mì Quảng");
        stringList.add("Hủ Tíu Sài Gòn");
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.layoutlab4foodlist, R.id.idtextlab4foodlist, stringList);
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

                    Intent intent = new Intent(FoodActivity.this, Mainlab4.class);
                    intent.putExtra("key", chooseFood);
                    stringList.add(chooseFood);
                    startActivity(intent);
                }
            }
        });
    }
}