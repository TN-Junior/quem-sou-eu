package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
                // Redirecionar aleatoriamente para JogoPersonagem ou JogoPersonagem2
                Class<?> targetActivity;
                Random random = new Random();
                if (random.nextBoolean()) {
                    targetActivity = JogoPersonagem.class;
                } else {
                    targetActivity = JogoPersonagem2.class;
                }
                Intent intent = new Intent(JogosFiltro.this, targetActivity);
                startActivity(intent);
            }
        });
    }
}