package com.example.myapplication;

import android.content.pm.ActivityInfo;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myapplication.JogoPersonagem;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class JogoPersonagemTest {

    @Test
    public void testScreenOrientation() {
        try (ActivityScenario<JogoPersonagem> scenario = ActivityScenario.launch(JogoPersonagem.class)) {
            scenario.onActivity(activity -> {
                int orientation = activity.getRequestedOrientation();
                assertEquals(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE, orientation);
            });
        }
    }
}