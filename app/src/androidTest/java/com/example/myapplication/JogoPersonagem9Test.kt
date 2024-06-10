package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class JogoPersonagem9Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(JogoPersonagem9::class.java)

    @Test
    fun testTextViewContent() {
        // Verifica se o TextView com id characters_textview contém o texto correto
        onView(withId(R.id.characters_textview))
            .check(matches(withText("Lebron James")))
    }

    @Test
    fun testBackButtonIsDisplayed() {
        // Verifica se o ImageButton com id back_button está visível
        onView(withId(R.id.back_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testActivityIsInLandscapeMode() {
        // Verifica se a Activity está na orientação paisagem
        val context = androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().targetContext
        val orientation = context.resources.configuration.orientation
        assert(orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE)
    }
}
