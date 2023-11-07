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

public class Lab2Layoutexe02 extends Activity {
    Button btnBack;

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private void updateDisplay(Operation operation, EditText editTextFirstNumber, EditText editTextSecondNumber, TextView textViewResult) {
        try {
            boolean isValid = true;
            String firstNumberStr = editTextFirstNumber.getText().toString();
            String secondNumberStr = editTextSecondNumber.getText().toString();
            if (firstNumberStr.trim().isEmpty()) {
                editTextFirstNumber.setError("Please enter a number");
                isValid = false;
            }
            if (secondNumberStr.trim().isEmpty()) {
                editTextSecondNumber.setError("Please enter a number");
                isValid = false;
            }
            if (!isValid) {
                return;
            }
            int first = Integer.parseInt(firstNumberStr);
            int second = Integer.parseInt(secondNumberStr);
            switch (operation) {
                case ADD:
                    textViewResult.setText(String.format("Result: %d + %d = %d", first, second, first + second));
                    break;
                case SUBTRACT:
                    textViewResult.setText(String.format("Result: %d - %d = %d", first, second, first - second));
                    break;
                case MULTIPLY:
                    textViewResult.setText(String.format("Result: %d * %d = %d", first, second, first * second));
                    break;
                case DIVIDE:
                    if (second == 0) {
                        Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    textViewResult.setText(String.format("Result: %d / %d = %f", first, second, (first / (double) second)));
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab2exe02);
        btnBack = findViewById(R.id.idlab2Back02);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lab2Layoutexe02.this, Lab2Activity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi khi chuyển đổi sang màn hình chính");
                }

            }
        });
        // EditTexts
        EditText editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        EditText editTextSecondNumber = findViewById(R.id.editTextSecondNumber);

        // Buttons
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);

        // TextViews
        TextView textViewResult = findViewById(R.id.txtviewrull);


        btnAdd.setOnClickListener(v -> updateDisplay(Operation.ADD, editTextFirstNumber, editTextSecondNumber, textViewResult));
        btnSubtract.setOnClickListener(v -> updateDisplay(Operation.SUBTRACT, editTextFirstNumber, editTextSecondNumber, textViewResult));
        btnMultiply.setOnClickListener(v -> updateDisplay(Operation.MULTIPLY, editTextFirstNumber, editTextSecondNumber, textViewResult));
        btnDivide.setOnClickListener(v -> updateDisplay(Operation.DIVIDE, editTextFirstNumber, editTextSecondNumber, textViewResult));
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

