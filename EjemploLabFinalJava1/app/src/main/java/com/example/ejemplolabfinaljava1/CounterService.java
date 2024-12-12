package com.example.ejemplolabfinaljava1;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class CounterService extends Service {
    public static final String ACTION_UPDATE = "com.example.cookieclicker.UPDATE";
    public static final String EXTRA_COUNT = "counter";  // Usar una constante para la clave del extra
    private int counter = 0;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();

        // Incrementar el contador cada segundo
        runnable = new Runnable() {
            @Override
            public void run() {
                counter++;
                sendBroadcast();
                handler.postDelayed(this, 1000); // Ejecutar cada segundo
            }
        };

        handler.post(runnable);
    }

    private void sendBroadcast() {
        // Crear el intent y pasar el valor del contador
        Intent intent = new Intent(ACTION_UPDATE);
        intent.putExtra(EXTRA_COUNT, counter);  // Usar la constante para la clave
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null; // No es necesario para un servicio sin enlace
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // Detener el handler cuando el servicio se destruye
    }
}
