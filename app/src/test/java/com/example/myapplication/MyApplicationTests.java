package com.example.myapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MyApplicationTests {

    private ActivityScenario<MainActivity> mainActivityScenario;
    private ActivityScenario<instrucoes> instrucoesActivityScenario;
    private ActivityScenario<JogoPersonagem> jogoPersonagemActivityScenario;
    private ActivityScenario<JogoPersonagem2> jogoPersonagem2ActivityScenario;
    private ActivityScenario<Jogos> jogosActivityScenario;
    private ActivityScenario<JogosFiltro> jogosFiltroActivityScenario;

    @Before
    public void setUp() {
        // Initialize the scenarios
        mainActivityScenario = ActivityScenario.launch(MainActivity.class);
        instrucoesActivityScenario = ActivityScenario.launch(instrucoes.class);
        jogoPersonagemActivityScenario = ActivityScenario.launch(JogoPersonagem.class);
        jogoPersonagem2ActivityScenario = ActivityScenario.launch(JogoPersonagem2.class);
        jogosActivityScenario = ActivityScenario.launch(Jogos.class);
        jogosFiltroActivityScenario = ActivityScenario.launch(JogosFiltro.class);
    }

    @After
    public void tearDown() {
        // Close the scenarios
        mainActivityScenario.close();
        instrucoesActivityScenario.close();
        jogoPersonagemActivityScenario.close();
        jogoPersonagem2ActivityScenario.close();
        jogosActivityScenario.close();
        jogosFiltroActivityScenario.close();
    }

    @Test
    public void testMainActivityOrientation() {
        mainActivityScenario.onActivity(activity -> {
            assertEquals(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE, activity.getRequestedOrientation());
        });
    }

    @Test
    public void testInstrucoesActivityOrientation() {
        instrucoesActivityScenario.onActivity(activity -> {
            assertEquals(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE, activity.getRequestedOrientation());
        });
    }

    @Test
    public void testJogoPersonagem2ActivityOrientation() {
        jogoPersonagem2ActivityScenario.onActivity(activity -> {
            assertEquals(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE, activity.getRequestedOrientation());
        });
    }

    @Test
    public void testInstrucoesBackButton() {
        instrucoesActivityScenario.onActivity(activity -> {
            Button backButton = activity.findViewById(R.id.back_button);
            assertNotNull(backButton);
            assertEquals(View.VISIBLE, backButton.getVisibility());
        });
    }

    @Test
    public void testJogoPersonagemBackButton() {
        jogoPersonagemActivityScenario.onActivity(activity -> {
            ImageButton backButton = activity.findViewById(R.id.back_button);
            assertNotNull(backButton);
            assertEquals(View.VISIBLE, backButton.getVisibility());
        });
    }

    @Test
    public void testJogosFiltroPreferences() {
        jogosFiltroActivityScenario.onActivity(activity -> {
            SharedPreferences preferences = activity.getSharedPreferences("JogosFiltroPreferences", Context.MODE_PRIVATE);
            assertNotNull(preferences);
            boolean lastWasPersonagem1 = preferences.getBoolean("lastActivity", false);
            assertFalse(lastWasPersonagem1);
        });
    }
}
