package com.example.myapplication.projectlab.Lab10.Exe1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Exercise1 extends AppCompatActivity {
    public enum DialogType {
        CREATE,
        UPDATE
    }
Button btnlab10back;
    ListView listView;
    ImageView icAdd;
    TraineeListViewAdapter traineeAdapter;
    TraineeService traineeService;
    List<Trainee> traineeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab10exe011);
        icAdd = findViewById(R.id.icAdd);
        icAdd.setOnClickListener(v -> showDialog(DialogType.CREATE, null));
        traineeService = TraineeRepository.getTraineeService();
        listView = findViewById(R.id.listView);
        traineeAdapter = new TraineeListViewAdapter(Exercise1.this, traineeList, R.layout.row_trainee);
        listView.setAdapter(traineeAdapter);
        loadTrainees();
        btnlab10back = findViewById(R.id.button2);
        btnlab10back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercise1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showDialog(DialogType dialogType, Trainee currentTrainee) {
        Dialog dialog = new Dialog(Exercise1.this);
        dialog.setContentView(R.layout.create_update_trainee);

        TextView tvHeading = dialog.findViewById(R.id.tvHeading);
        TextView negativeButton = dialog.findViewById(R.id.negativeButton);
        TextView positiveButton = dialog.findViewById(R.id.positiveButton);

        EditText etTraineeName = dialog.findViewById(R.id.etTraineeName);
        EditText etTraineeEmail = dialog.findViewById(R.id.etTraineeEmail);
        EditText etTraineePhone = dialog.findViewById(R.id.etTraineePhone);
        RadioGroup rgTraineeGender = dialog.findViewById(R.id.rgTraineeGender);
        RadioButton rbMale = dialog.findViewById(R.id.rbMale);
        RadioButton rbFemale = dialog.findViewById(R.id.rbFemale);

        if (dialogType == DialogType.CREATE) {
            tvHeading.setText("Create Trainee");
            positiveButton.setText("Create");
        } else if (dialogType == DialogType.UPDATE) {
            tvHeading.setText("Update Trainee");
            positiveButton.setText("Update");
            etTraineeName.setText(currentTrainee.getName());
            etTraineeEmail.setText(currentTrainee.getEmail());
            etTraineePhone.setText(currentTrainee.getPhone());
            if (currentTrainee.getGender().equals("Male")) {
                rbMale.setChecked(true);
            } else if (currentTrainee.getGender().equals("Female")) {
                rbFemale.setChecked(true);
            }
        }

        negativeButton.setOnClickListener(v -> dialog.dismiss());

        positiveButton.setOnClickListener(v -> {
            String name = etTraineeName.getText().toString().trim();
            String email = etTraineeEmail.getText().toString().trim();
            String phone = etTraineePhone.getText().toString().trim();
            int checkedRadioButtonGenderId = rgTraineeGender.getCheckedRadioButtonId();
            String gender;
            if (name.isEmpty()) {
                etTraineeName.setError("Name is required");
                etTraineeName.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                etTraineeEmail.setError("Email is required");
                etTraineeEmail.requestFocus();
                return;
            }
            if (!ValidationUtils.isValidEmail(email)) {
                etTraineeEmail.setError("Invalid email");
                etTraineeEmail.requestFocus();
                return;
            }
            if (phone.isEmpty()) {
                etTraineePhone.setError("Phone is required");
                etTraineePhone.requestFocus();
                return;
            }
            if (checkedRadioButtonGenderId == -1) {
                Toast.makeText(this, "Gender is required", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton rbGender = dialog.findViewById(checkedRadioButtonGenderId);
            gender = rbGender.getText().toString();
            Trainee newTrainee = new Trainee(name, email, phone, gender);
            if (dialogType == DialogType.CREATE) {
                createTrainee(newTrainee);
            } else {
                updateTrainee(currentTrainee, newTrainee);
            }
            dialog.dismiss();
        });
        dialog.show();
    }

    public void loadTrainees() {
        traineeService.getAllTrainees()
                .enqueue(new Callback<List<Trainee>>() {
                    @Override
                    public void onResponse(Call<List<Trainee>> call, Response<List<Trainee>> response) {
                        traineeList = response.body();
                        if (traineeList != null && traineeList.size() > 0) {
                            traineeAdapter.setTraineeList(traineeList);
                            traineeAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Trainee>> call, Throwable t) {
                        Toast.makeText(Exercise1.this, "An error has occurred!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void deleteTrainee(Trainee traineeToDelete) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Exercise1.this);
        builder.setTitle("Delete Trainee");
        builder.setMessage("Are you sure you want to delete " + traineeToDelete.getName() + "?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            traineeService.deleteTrainee(traineeToDelete.getId())
                    .enqueue(new Callback<Trainee>() {
                        @Override
                        public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                            Toast.makeText(Exercise1.this, "Trainee " + traineeToDelete.getName() + " has been deleted!", Toast.LENGTH_SHORT).show();
                            traineeList.remove(traineeToDelete);
                            traineeAdapter.setTraineeList(traineeList);
                            traineeAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onFailure(Call<Trainee> call, Throwable t) {
                            Toast.makeText(Exercise1.this, "An error has occurred!", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.show();
    }

    public void createTrainee(Trainee trainee) {
        traineeService.createTrainee(trainee)
                .enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        Toast.makeText(Exercise1.this, "Trainee " + trainee.getName() + " has been added!", Toast.LENGTH_SHORT).show();
                        traineeList.add(response.body());
                        traineeAdapter.setTraineeList(traineeList);
                        traineeAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {
                        Toast.makeText(Exercise1.this, "An error has occurred!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void updateTrainee(Trainee currentTrainee, Trainee updateTrainee) {
        traineeService.updateTrainee(currentTrainee.getId(), updateTrainee)
                .enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        Toast.makeText(Exercise1.this, "Trainee has been updated!", Toast.LENGTH_SHORT).show();
                        traineeList.remove(currentTrainee);
                        traineeList.add(response.body());
                        traineeAdapter.setTraineeList(traineeList);
                        traineeAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {
                        Toast.makeText(Exercise1.this, "An error has occurred!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}