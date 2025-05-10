package es.unizar.eina.demonstrator;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.accessibility.AccessibilityChecks;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @see <a href="https://developer.android.com/guide/topics/ui/accessibility/testing">Test your app's accessibility</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccesibilityEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @BeforeClass
    public static void enableAccessibilityChecks() {
        AccessibilityChecks.enable();
    }
    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.inputField))
                .perform(typeText("Hello"), closeSoftKeyboard());
        onView(withText("Change Text")).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }

}