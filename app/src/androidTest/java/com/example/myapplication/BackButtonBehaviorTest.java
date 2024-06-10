package com.example.myapplication;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myapplication.JogoPersonagem;
import com.example.myapplication.Jogos;
import com.example.myapplication.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class JogoPersonagemInstrumentedTest {

    @Test
    public void testBackButton() {
        try (ActivityScenario<JogoPersonagem> scenario = ActivityScenario.launch(JogoPersonagem.class)) {
            onView(withId(R.id.back_button)).perform(ViewActions.click());
            onView(withId(R.id.jogos_layout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        }
    }
}