package com.example.myapplication.projectlab.Lab3.Exe03;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.Lab3.Exe01.Run;
import com.example.myapplication.projectlab.Lab3.Exe01.TraiCay;
import com.example.myapplication.projectlab.Lab3.Exe01.TraiCayAdapt;
import com.example.myapplication.projectlab.Lab3.Lab3Activity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;

public class RunPlayer extends AppCompatActivity {
    ListView listView;
    ArrayList<PlayerSoccer> playerSoccers;
    PlayerSoccerAdapt adapt;
    Button btnBack;

    Button btnAdd;
    Button btnUpdate;
    Button btnDelete;
    EditText inputName;
    EditText inputDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab3exe01);
        AnhXa();
        adapt = new PlayerSoccerAdapt(this, R.layout.layoutlab3exe03, playerSoccers);
        listView.setAdapter(adapt);

        btnBack = findViewById(R.id.idbtnlab3exe01Back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(RunPlayer.this, Lab3Activity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorDialog("Lỗi chuyển đổi màn hình");
                }

            }
        });
        btnDelete = findViewById(R.id.idbtnLab3Detele);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int selectedItemPosition = listView.getCheckedItemPosition();
                    if (selectedItemPosition == ListView.INVALID_POSITION) {
                        Toast.makeText(RunPlayer.this, "Vui lòng chọn một cau thu để cập nhật.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    playerSoccers.remove(selectedItemPosition);
                    adapt.notifyDataSetChanged();


                }catch (Exception e){
                    e.printStackTrace();
                    showErrorDialog(e.getMessage().toString());
                }
            }
        });
        btnUpdate = findViewById(R.id.idbtnlab3update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int selectedItemPosition = listView.getCheckedItemPosition();
                    if (selectedItemPosition == ListView.INVALID_POSITION) {
                        Toast.makeText(RunPlayer.this, "Vui lòng chọn một cau thu để cập nhật.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Lấy thông tin trái cây đã chọn
                    PlayerSoccer selectedFruit = playerSoccers.get(selectedItemPosition);

                    AlertDialog.Builder builder = new AlertDialog.Builder(RunPlayer.this);
                    builder.setTitle("Update");

                    inputName = new EditText(RunPlayer.this);
                    inputDesc = new EditText(RunPlayer.this);

                    inputName.setText(selectedFruit.getTen());
                    inputDesc.setText(selectedFruit.getMota());


                    LinearLayout layout = new LinearLayout(RunPlayer.this);
                    layout.setOrientation(LinearLayout.VERTICAL);
                    layout.addView(inputName);
                    layout.addView(inputDesc);
                    builder.setView(layout);

                    builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String updatedName = inputName.getText().toString();
                            String updatedDesc = inputDesc.getText().toString();

                            selectedFruit.setTen(updatedName);
                            selectedFruit.setMota(updatedDesc);

                            adapt.notifyDataSetChanged();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(RunPlayer.this);
                builder.setTitle("Add");

                inputName = new EditText(RunPlayer.this);
                inputName.setHint("Nhập tên");
                inputDesc = new EditText(RunPlayer.this);
                inputDesc.setHint("Nhập Decs ");

                LinearLayout layout = new LinearLayout(RunPlayer.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(inputName);
                layout.addView(inputDesc);
                builder.setView(layout);

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = inputName.getText().toString();
                        String desc = inputDesc.getText().toString();
                        if (desc.isEmpty() || name.isEmpty()) {
                            Toast.makeText(RunPlayer.this, "Missing fields", Toast.LENGTH_SHORT).show();
                        }
                        PlayerSoccer playerSoccer = new PlayerSoccer(name, desc, R.drawable.ic_launcher_foreground, R.drawable.covietnam);

                        playerSoccers.add(playerSoccer);

                        adapt.notifyDataSetChanged();
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
        playerSoccers = new ArrayList<>();
        playerSoccers.add(new PlayerSoccer(" Kylian Mbappé", " 20-12-1998", R.drawable.mbappe, R.drawable.phap));
        playerSoccers.add(new PlayerSoccer(" Neymar", " 5-2-1992 ", R.drawable.neymar, R.drawable.brazil));
        playerSoccers.add(new PlayerSoccer(" Ronaldo", " 5-2-1985 ", R.drawable.ronaldo, R.drawable.bodaonha));
        playerSoccers.add(new PlayerSoccer(" Messi ", " 24-6-1987 ", R.drawable.messi, R.drawable.argentina));

    }

    private void showErrorDialog(String errorMessage) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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
