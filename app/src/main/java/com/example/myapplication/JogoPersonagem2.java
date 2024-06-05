package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JogoPersonagem2 extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "JogosFiltroPreferences";
    private static final String LAST_ACTIVITY_KEY = "lastActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jogo_personagem2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a tela de Jogos
                Intent intent = new Intent(JogoPersonagem2.this, Jogos.class);
                startActivity(intent);
                finish();
            }
        });

        View rootView = findViewById(android.R.id.content);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleActivity();
            }
        });
    }

    private void toggleActivity() {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        boolean lastWasPersonagem1 = preferences.getBoolean(LAST_ACTIVITY_KEY, false);  // Considerando que esta é JogoPersonagem2, defina false por padrão

        Class<?> nextActivity;
        if (lastWasPersonagem1) {
            nextActivity = JogoPersonagem2.class;
        } else {
            nextActivity = JogoPersonagem.class;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(LAST_ACTIVITY_KEY, !lastWasPersonagem1);
        editor.apply();

        Intent intent = new Intent(JogoPersonagem2.this, nextActivity);
        startActivity(intent);
        finish();
    }
}
