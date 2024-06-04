package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define a orientação da tela como paisagem (horizontal)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.play_button);
        Button instructionsButton = findViewById(R.id.instructions_button);
        Button exitButton = findViewById(R.id.exit_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicionando Intent para redirecionar para JogosFiltro
                Intent intent = new Intent(MainActivity.this, JogosFiltro.class);
                startActivity(intent);
            }
        });

        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicionando Intent para redirecionar para instrucoes
                Intent intent = new Intent(MainActivity.this, instrucoes.class);
                startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a Activity atual
            }
        });
    }
}
