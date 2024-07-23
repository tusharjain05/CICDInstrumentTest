package com.example.testbutton;

import android.content.Context;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TestMainActivity {

    private Context appContext;

    @Before
    public void setup() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void testEmptyInputs() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.validationMessage)).check(matches(withText("Empty")));
    }

    @Test
    public void testIncorrectNumberInput() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.numberInput)).perform(replaceText("abc"));
        onView(withId(R.id.alphabetInput)).perform(replaceText("test"));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.validationMessage)).check(matches(withText("Wrong: Numbers only in first field")));
    }

    @Test
    public void testIncorrectAlphabetInput() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.numberInput)).perform(replaceText("123"));
        onView(withId(R.id.alphabetInput)).perform(replaceText("123"));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.validationMessage)).check(matches(withText("Wrong: Alphabets only in second field")));
    }

    @Test
    public void testCorrectInputs() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.numberInput)).perform(replaceText("123"));
        onView(withId(R.id.alphabetInput)).perform(replaceText("test"));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.validationMessage)).check(matches(withText("Correct")));
    }
}
