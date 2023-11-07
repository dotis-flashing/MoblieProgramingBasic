package com.example.myapplication.projectlab.Lab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.projectlab.R;

public class Lab2Layoutexe031 extends Lab2Activity implements View.OnClickListener {

    private final String REQUIRE = "Require";

    EditText editTextUsername;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    Button buttonSignUp;
    TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab2exe031);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewSignIn = findViewById(R.id.textViewSignIn);


        buttonSignUp.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
    }

    private boolean checkInput() {
        try {
            if (TextUtils.isEmpty(editTextUsername.getText().toString())) {
                editTextUsername.setError(REQUIRE);
                return false;
            }

            if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
                editTextPassword.setError(REQUIRE);
                return false;
            }

            if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString())) {
                editTextConfirmPassword.setError(REQUIRE);
                return false;
            }

            if (!TextUtils.equals(editTextPassword.getText().toString(), editTextConfirmPassword.getText().toString())) {
                Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Error An error occurred, " + e.getMessage().toString());
        }


        return true;
    }

    private void signUp() {
        try {
            if (!checkInput()) {
                return;
            }
            Toast.makeText(this, "Sign up success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Lab2Layoutexe03.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Lỗi chuyển đổi màn hình");
        }

    }

    private void singInForm() {
        try {
            Intent intent = new Intent(this, Lab2Layoutexe03.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Lỗi chuyển đổi màn hình");
        }

    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.buttonSignUp) {
                signUp();
            } else if (v.getId() == R.id.textViewSignIn) {
                singInForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Lỗi chuyển đổi màn hình");
        }

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
