package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Jogos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_jogos);

        // Configura o padding para acomodar as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configura os cliques dos botões
        Button personagensButton = findViewById(R.id.personagens_button);
        Button famososButton = findViewById(R.id.famosos);
        Button voltarButton = findViewById(R.id.voltar_button);

        personagensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a tela de JogoPersonagem
                Intent intent = new Intent(Jogos.this, JogoPersonagem.class);
                startActivity(intent);
            }
        });

        famososButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a tela de JogoPersonagem2
                Intent intent = new Intent(Jogos.this, JogoPersonagem2.class);
                startActivity(intent);
            }
        });

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para lidar com o clique do botão voltar...
                finish(); // Fecha a atividade atual e volta para a anterior (se houver)
            }
        });
    }
}