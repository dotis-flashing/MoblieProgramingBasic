package com.example.myapplication.projectlab.Lab3.Exe02;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.projectlab.Lab3.Lab3Activity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewLanguage extends Lab3Activity {

    private static int CURRENT_POST = -1;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab3exe02);
        ListView listView = findViewById(R.id.idLab3listviewexe02);
        EditText editNameinput = findViewById(R.id.editinputvalue);
        Button buttonAdd = findViewById(R.id.idbtnLab3Addexe02);
        Button buttonUpdate = findViewById(R.id.idbtnLab3Updateexe02);
//        Button buttonRemove = findViewById(R.id.idbtnLab3Deleteexe02);

        btnBack = findViewById(R.id.idbtnBackLab3exe02);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(ListViewLanguage.this,Lab3Activity.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog("Lỗi chuyển đổi màn hình");
                }

            }
        });

        List<String> stringList = new ArrayList<>();
        stringList.add("Python");
        stringList.add("Machine Learning");
        stringList.add("Deep Learning");
        stringList.add("Neural Network");
        stringList.add("Computer Vision");

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.layoutlab3exe023, R.id.idLab3texttextexe023, stringList);
        listView.setAdapter(adapter);


        buttonAdd.setOnClickListener(v -> {
            String edittextInput = editNameinput.getText().toString().trim();
            if (edittextInput.isEmpty()) {
                editNameinput.setError("Blank value is not allowed");
                editNameinput.requestFocus();
                return;
            }
            if (stringList.contains(edittextInput)) {
                editNameinput.setError("Item already exists");
                editNameinput.requestFocus();
                return;
            }
            stringList.add(edittextInput);
            adapter.notifyDataSetChanged();
            editNameinput.setText("");
        });
        listView.setOnItemLongClickListener((parent, view, postion, id) -> {
            stringList.remove(postion);
            editNameinput.setText("");
            CURRENT_POST = -1;
            adapter.notifyDataSetChanged();
            return true;
        });
        listView.setOnItemClickListener((parent, view, position, id) -> {
            editNameinput.setText(stringList.get(position));
            CURRENT_POST = position;
        });
        buttonUpdate.setOnClickListener(v -> {
            String edittextInput = editNameinput.getText().toString().trim();
            if (stringList.isEmpty()) {
                editNameinput.setError("List is empty");
                editNameinput.requestFocus();
                return;
            }
            if (CURRENT_POST == -1) {
                editNameinput.setError("Please select an item first");
                editNameinput.requestFocus();
                return;
            }
            if (edittextInput.isEmpty()) {
                editNameinput.setError("Blank value is not allowed");
                editNameinput.requestFocus();
                return;
            }
            if (edittextInput.equals(stringList.get(CURRENT_POST))) {
                editNameinput.setError("You have not changed anything");
                editNameinput.requestFocus();
                return;
            }
            if (stringList.contains(edittextInput)) {
                editNameinput.setError("Item already exists");
                editNameinput.requestFocus();
                return;
            }
            String oldText = stringList.get(CURRENT_POST);
            stringList.set(CURRENT_POST, edittextInput);
            adapter.notifyDataSetChanged();
            editNameinput.setText("");
            CURRENT_POST = -1;
            Toast.makeText(this, oldText + "has been update to " + edittextInput, Toast.LENGTH_SHORT).show();
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
