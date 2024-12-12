package com.example.ejemplolabfinaljava1;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CounterReceiver counterReceiver;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);

        // Registrar el BroadcastReceiver
        counterReceiver = new CounterReceiver(counterTextView);
        IntentFilter filter = new IntentFilter(CounterService.ACTION_UPDATE);
        // Solo registra el receptor si es necesario (asegúrate de que esté configurado correctamente en el manifiesto)
        registerReceiver(counterReceiver, filter);

        // Iniciar el servicio
        Intent intent = new Intent(this, CounterService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Detener el servicio y desregistrar el receiver
        Intent intent = new Intent(this, CounterService.class);
        stopService(intent);

        // Desregistrar el receiver si lo registraste dinámicamente
        if (counterReceiver != null) {
            unregisterReceiver(counterReceiver);
        }
    }
}
