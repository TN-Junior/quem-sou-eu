package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class JogosFiltro extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private float[] accelerometerValues = new float[3];
    private Class<?> currentTargetActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_jogos_filtro);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.title_textview), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        currentTargetActivity = JogoPersonagem.class;

        Button voltarButton = findViewById(R.id.voltar_button);
        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para MainActivity
                Intent intent = new Intent(JogosFiltro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button filtrarButton = findViewById(R.id.famosos);
        filtrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a tela de Jogos
                Intent intent = new Intent(JogosFiltro.this, Jogos.class);
                startActivity(intent);
            }
        });

        Button personagensButton = findViewById(R.id.personagens_button);
        personagensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a tela de Personagem atual
                Intent intent = new Intent(JogosFiltro.this, currentTargetActivity);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            accelerometerValues = event.values;

            float x = accelerometerValues[0];
            float y = accelerometerValues[1];
            float z = accelerometerValues[2];

            if (Math.abs(x) > Math.abs(y) && Math.abs(x) > Math.abs(z)) {
                // Dispositivo está deitado (eixo x)
                if (x > 0) {
                    // Dispositivo está virado para cima
                    currentTargetActivity = JogoPersonagem.class;
                } else {
                    // Dispositivo está virado para baixo
                    currentTargetActivity = JogoPersonagem2.class;
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // por enquanto não precisa mexer
        }
    };
}