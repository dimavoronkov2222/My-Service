package com.dmytro.service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startServiceButton = findViewById(R.id.startServiceButton);
        Button stopServiceButton = findViewById(R.id.stopServiceButton);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Запуск сервиса");
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });
        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Остановка сервиса");
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });
    }
}