package com.example.myapplication.projectlab.Lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;

public class Lab5Activity extends AppCompatActivity {
    ArrayList<Module> moduleList;
    Button btnLab5back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab5activity);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        moduleList = new ArrayList<>();
        moduleList.add(new Module(" ListView trong Android", " ListView trong Android là một thành phần dùng để nhóm nhiều mục (item) khác nhau...", R.drawable.android));
        moduleList.add(new Module(" Xử lý dữ kiện trong IOS", " Xử lý dữ kiện trong IOS, sau khi các bạn đã biết cách thiết kế giao diện cho các ứng dụng...", R.drawable.ios));

        ModuleAdapter moduleAdapter = new ModuleAdapter(moduleList);

        recyclerView.setAdapter(moduleAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        btnLab5back = findViewById(R.id.idbtnbacklab5);
        btnLab5back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lab5Activity.this, MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(Lab5Activity.this, "Lỗi khi chuyển đổi sang màn hình chính", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}