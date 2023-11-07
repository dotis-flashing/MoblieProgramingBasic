package com.example.myapplication.projectlab.Lab3.Exe01;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.Lab3.Lab3Activity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;
import java.util.List;

public class Run extends AppCompatActivity {
    ListView listView;
    ArrayList<TraiCay> traiCays;
    TraiCayAdapt adapt;
    Button btnBack;
    Button btnAdd;
    Button btnUpdate;
    Button btnDelete;
    ListView listViewImage;
    EditText inputName;
    EditText inputImage;
    List<Integer> listImage;
    EditText inputDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab3exe01);
        AnhXa();
        adapt = new TraiCayAdapt(this, R.layout.layoutlab3exe012, traiCays);
        listView.setAdapter(adapt);

        btnBack = findViewById(R.id.idbtnlab3exe01Back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Run.this, Lab3Activity.class);
                startActivity(intent);
            }
        });
        btnUpdate = findViewById(R.id.idbtnlab3update);
        btnDelete = findViewById(R.id.idbtnLab3Detele);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int selectedItemPosition = listView.getCheckedItemPosition();
                    if (selectedItemPosition == ListView.INVALID_POSITION) {
                        Toast.makeText(Run.this, "Vui lòng chọn một trái cây để cập nhật.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    traiCays.remove(selectedItemPosition);
                    adapt.notifyDataSetChanged();


                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog(e.getMessage().toString());
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int selectedItemPosition = listView.getCheckedItemPosition();
                    if (selectedItemPosition == ListView.INVALID_POSITION) {
                        Toast.makeText(Run.this, "Vui lòng chọn một trái cây để cập nhật.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    TraiCay selectedFruit = traiCays.get(selectedItemPosition);

                    AlertDialog.Builder builder = new AlertDialog.Builder(Run.this);
                    builder.setTitle("Update");

                    inputName = new EditText(Run.this);
                    inputDesc = new EditText(Run.this);

//                    inputImage.setText(String.valueOf(selectedFruit.getImage()));
                    inputName.setText(selectedFruit.getTen());
                    inputDesc.setText(selectedFruit.getMota());

//                    inputImage.setFocusable(false);
//                    inputImage.setClickable(false);

                    LinearLayout layout = new LinearLayout(Run.this);
                    layout.setOrientation(LinearLayout.VERTICAL);
                    layout.addView(inputName);
                    layout.addView(inputDesc);
                    builder.setView(layout);

                    builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                String updatedName = inputName.getText().toString();
                                String updatedDesc = inputDesc.getText().toString();

                                selectedFruit.setTen(updatedName);
                                selectedFruit.setMota(updatedDesc);

                                adapt.notifyDataSetChanged();
                            } catch (Exception e) {
                                e.printStackTrace();
                                showErrorDialog(e.getMessage().toString());
                            }
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog(e.getMessage().toString());
                }

            }
        });


        btnAdd = findViewById(R.id.idbtnlab3them);
        btnAdd.setOnClickListener(v -> {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(Run.this);
                builder.setTitle("Add");

                inputName = new EditText(Run.this);
                inputName.setHint("Nhập tên");
                inputDesc = new EditText(Run.this);
                inputDesc.setHint("Nhập Desc");

                LinearLayout layout = new LinearLayout(Run.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(inputName);
                layout.addView(inputDesc);
                builder.setView(layout);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            String name = inputName.getText().toString();
                            String desc = inputDesc.getText().toString();
                            if (desc.isEmpty() || name.isEmpty()) {
                                Toast.makeText(Run.this, "Missing fields", Toast.LENGTH_SHORT).show();
                            }

                            TraiCay traiCay = new TraiCay(name, desc, R.drawable.ic_launcher_foreground);

                            traiCays.add(traiCay);

                            adapt.notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                            showErrorDialog(e.getMessage().toString());
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            } catch (Exception e) {
                e.printStackTrace();
                showErrorDialog(e.getMessage().toString());
            }

        });


    }

    private void AnhXa() {
        listView = findViewById(R.id.idlab3listview);
        traiCays = new ArrayList<>();
        traiCays.add(new TraiCay("Anh đào", "(Cherry)", R.drawable.anhdao));
        traiCays.add(new TraiCay("Bình bát", "Annona reticulata", R.drawable.binhbat));
        traiCays.add(new TraiCay("Bòn bon", "Lansium domesticum Hiern", R.drawable.bonbon));
        traiCays.add(new TraiCay("Bơ", "Persea americana Mill", R.drawable.bo));
        traiCays.add(new TraiCay("Bưởi", "Bưởi Citrus grandis", R.drawable.buoi));

    }

    private void AddImage() {
        listImage = new ArrayList<Integer>();
        listImage.add(R.drawable.chuoi);
        listImage.add(R.drawable.cam);
        listImage.add(R.drawable.chuoi);
        listImage.add(R.drawable.anhdao);
        listImage.add(R.drawable.thanhlong);
        listImage.add(R.drawable.dudu);
        listImage.add(R.drawable.bo);
        listImage.add(R.drawable.binhbat);
    }

    private void ShowListImage() {
        listViewImage = new ListView(this);
        for (Integer imageView : listImage) {
                
        }
    }

    private void showErrorDialog(String errorMessage) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Lỗi");
        builder.setMessage(errorMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
