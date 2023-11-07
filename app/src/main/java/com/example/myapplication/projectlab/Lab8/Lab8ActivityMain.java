package com.example.myapplication.projectlab.Lab8;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.projectlab.MainActivity;
import com.example.myapplication.projectlab.R;

public class Lab8ActivityMain extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "MyChannel";
    Button btnLab8Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlab8activity);

        createNotificationChannel(); // Tạo kênh thông báo (yêu cầu cho Android 8.0 trở lên)

        Button btnSendNotification = findViewById(R.id.button);

        btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
        btnLab8Back = findViewById(R.id.idbtnlab8back);
        btnLab8Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lab8ActivityMain.this, MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel Name";
            String description = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    void sendNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Title push notification")
                .setContentText("Message push notification")
                .setLargeIcon(bitmap)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // Kiểm tra quyền thông báo
        if (ActivityCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != PackageManager.PERMISSION_GRANTED) {
            // Nếu không có quyền, yêu cầu quyền
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 0);
        } else {
            // Nếu có quyền, hiển thị thông báo
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
