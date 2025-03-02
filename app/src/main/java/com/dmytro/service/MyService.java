package com.dmytro.service;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
public class MyService extends Service {
    private static final String TAG = "MyService";
    private static final String CHANNEL_ID = "MyServiceChannel";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Сервис создан");
        createNotificationChannel();
    }
    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Сервис запущен");
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Сервис работает")
                .setContentText("Это Foreground Service")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        startForeground(1, notification);
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Сервис уничтожен");
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void createNotificationChannel() {
        NotificationChannel serviceChannel = new NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        NotificationManager manager = getSystemService(NotificationManager.class);
        if (manager != null) {
            manager.createNotificationChannel(serviceChannel);
        }
    }
}