package com.example.myapplication.projectlab.Lab1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.projectlab.R;

public class Lab1Layout1 extends Activity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout1);
        btnBack = findViewById(R.id.idbtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lab1Layout1.this,Lab1Activity.class);
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
