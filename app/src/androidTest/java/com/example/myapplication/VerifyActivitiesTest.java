package com.example.myapplication;

import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class VerifyActivitiesTest {

    private static final String PREFERENCES_NAME = "JogosFiltroPreferences";
    private static final String LAST_ACTIVITY_KEY = "lastActivity";

    private SharedPreferences sharedPreferences;

    @Before
    public void setUp() {
        sharedPreferences = ApplicationProvider.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(LAST_ACTIVITY_KEY, true).apply();
    }

    @Test
    public void testToggleActivity() {
        try (ActivityScenario<JogoPersonagem> scenario = ActivityScenario.launch(JogoPersonagem.class)) {
            scenario.onActivity(activity -> {
                activity.toggleActivity();
                Intent expectedIntent = new Intent(activity, JogoPersonagem2.class);
                assertTrue(activity.isFinishing());
            });
        }
    }
}
