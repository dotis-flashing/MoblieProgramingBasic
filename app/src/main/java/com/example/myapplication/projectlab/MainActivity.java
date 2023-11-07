package com.example.myapplication.projectlab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.Lab1.Lab1Activity;
import com.example.myapplication.projectlab.Lab10.Exe1.Exercise1;
import com.example.myapplication.projectlab.Lab2.Lab2Activity;
import com.example.myapplication.projectlab.Lab3.Lab3Activity;
import com.example.myapplication.projectlab.Lab4.Mainlab4;
import com.example.myapplication.projectlab.Lab5.Lab5Activity;
import com.example.myapplication.projectlab.Lab8.Lab8ActivityMain;

public class MainActivity extends AppCompatActivity {
    Button btnLab1;
    Button btnLab2;
    Button btnLab3;
    Button btnLab4;
    Button btnLab5;
    Button btnLab8;
    Button btnLab10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLab1 = findViewById(R.id.idbtnLab1);

        btnLab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Lab1Activity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnLab2 = findViewById(R.id.idbtnLab2);
        btnLab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Lab2Activity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnLab3 = findViewById(R.id.idlab3);
        btnLab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Lab3Activity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnLab4 = findViewById(R.id.idlab4);
        btnLab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Mainlab4.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnLab5 = findViewById(R.id.idlab5);
        btnLab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Lab5Activity.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnLab8 = findViewById(R.id.idlab8);
        btnLab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Lab8ActivityMain.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnLab10 = findViewById(R.id.idbtnLab10code);
        btnLab10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Exercise1.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
    }

    private void showErrorDialog(String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lỗi");
        builder.setMessage(errorMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Đóng hộp thoại và thực hiện các hành động cần thiết (nếu có)
                dialog.dismiss();
            }
        });
        builder.show();
    }
}