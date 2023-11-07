package com.example.myapplication.projectlab.Lab2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.projectlab.R;

import java.util.Random;

public class Lab2Layoutexe01 extends Activity {
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2random);
        btnBack = findViewById(R.id.idLab2backexe01);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lab2Layoutexe01.this, Lab2Activity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        EditText editTextMin = findViewById(R.id.editTextNumberMin);
        EditText editTextMax = findViewById(R.id.editTextNumberMax);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        TextView textViewResult = findViewById(R.id.textViewResult);
        btnGenerate.setOnClickListener(v -> {
            try {
                boolean isValid = true;
                String minStr = editTextMin.getText().toString();
                String maxStr = editTextMax.getText().toString();
                if (minStr.trim().isEmpty()) {
                    editTextMin.setError("Please enter a number");
                    isValid = false;
                }
                if (maxStr.trim().isEmpty()) {
                    editTextMax.setError("Please enter a number");
                    isValid = false;
                }
                if (!isValid) {
                    return;
                }
                int min = Integer.parseInt(minStr);
                int max = Integer.parseInt(maxStr);
                if (min >= max) {
                    Toast.makeText(this, "Max number must be greater than the min one.", Toast.LENGTH_SHORT).show();
                } else {
                    Random random = new Random();
                    int result = random.nextInt(max - min + 1) + min;
                    textViewResult.setText("Result: " + result);
                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
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