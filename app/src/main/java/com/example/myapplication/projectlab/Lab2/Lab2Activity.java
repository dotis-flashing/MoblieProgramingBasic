package com.example.myapplication.projectlab.Lab2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.Lab1.Lab1Layout3;
import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

public class Lab2Activity extends Activity {
    Button btnBack;
    Button btnexe01;
    Button btnexe02;
    Button btnexe03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylab2);
        btnBack = findViewById(R.id.idlab2back2);
        btnexe01 = findViewById(R.id.idlab2exe01);
        btnexe02 = findViewById(R.id.idlab2exe02);
        btnexe03 = findViewById(R.id.idlab2exe03);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Lab2Activity.this, MainActivity.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnexe01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Lab2Activity.this, Lab2Layoutexe01.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnexe02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Lab2Activity.this, Lab2Layoutexe02.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        btnexe03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Lab2Activity.this, Lab2Layoutexe03.class);
                    startActivity(intent);
                }catch (Exception e){
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
