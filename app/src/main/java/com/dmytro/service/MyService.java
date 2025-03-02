package com.dmytro.service;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
public class MyService extends Service {
    private static final String TAG = "MyService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Сервис создан");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Сервис запущен");
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
}