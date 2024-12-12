package com.example.ejemplolabfinaljava1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class CounterReceiver extends BroadcastReceiver {

    private TextView counterTextView;

    // Constructor público sin argumentos
    public CounterReceiver() {
    }

    // Constructor con el TextView como parámetro
    public CounterReceiver(TextView counterTextView) {
        this.counterTextView = counterTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            // Verificar si la acción es la correcta
            if (intent.getAction().equals(CounterService.ACTION_UPDATE)) {
                // Obtener el contador de los extras
                int count = intent.getIntExtra(CounterService.EXTRA_COUNT, 0);

                // Actualizar el TextView si no es null
                if (counterTextView != null) {
                    counterTextView.setText(String.valueOf(count));
                }
            }
        }
    }
}
