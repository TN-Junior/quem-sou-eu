package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JogosFiltro extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "JogosFiltroPreferences";
    private static final String LAST_ACTIVITY_KEY = "lastActivity";

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
                Class<?> targetActivity = getNextActivity();
                Intent intent = new Intent(JogosFiltro.this, targetActivity);
                startActivity(intent);
            }
        });
    }

    private Class<?> getNextActivity() {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        boolean lastWasPersonagem1 = preferences.getBoolean(LAST_ACTIVITY_KEY, false);

        Class<?> nextActivity;
        if (lastWasPersonagem1) {
            nextActivity = JogoPersonagem2.class;
        } else {
            nextActivity = JogoPersonagem.class;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(LAST_ACTIVITY_KEY, !lastWasPersonagem1);
        editor.apply();

        return nextActivity;
    }
}
