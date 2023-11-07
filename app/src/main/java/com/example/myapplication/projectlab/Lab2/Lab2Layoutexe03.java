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

import com.example.myapplication.projectlab.R;

public class Lab2Layoutexe03 extends Lab2Activity implements View.OnClickListener {
    private static final int BUTTON_SIGN_IN_ID = R.id.buttonSignIn;

    private final String REQUIRE = "Require";

    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonSignIn;
    TextView textViewCreate;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab2exe03);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        textViewCreate = findViewById(R.id.textViewCreate);

        textViewCreate.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
        btnBack = findViewById(R.id.idlab2Backexe31);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Lab2Layoutexe03.this, Lab2Activity.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog("Lỗi chuyển đổi màn hình");
                }

            }
        });
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(editTextUsername.getText().toString())) {
            editTextUsername.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            editTextPassword.setError(REQUIRE);
            return false;
        }

        return true;
    }

    public void signIn() {
        try{
            if (!checkInput()) {
                return;
            }
            Intent intent = new Intent(this, HelloWorld.class);
            intent.putExtra("username", editTextUsername.getText().toString());
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
            showErrorDialog("Lỗi chuyển đổi màn hình : "+ e.getMessage().toString());
        }

    }

    public void signUpForm() {
        try{
            Intent intent = new Intent(this, Lab2Layoutexe031.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
            showErrorDialog("Lỗi chuyển đổi màn hình");
        }

    }

    @Override
    public void onClick(View view) {
        try {
            if (view.getId() == BUTTON_SIGN_IN_ID) {
                signIn();
            } else if (view.getId() == R.id.textViewCreate) {
                signUpForm();
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

