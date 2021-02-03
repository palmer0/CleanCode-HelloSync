package es.ulpgc.eite.cleancode.helloworld.cucumber;

import androidx.test.rule.ActivityTestRule;

import es.ulpgc.eite.cleancode.helloworld.R;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@SuppressWarnings("ALL")
public class HelloScreenRobot {

    private ActivityTestRule<HelloActivity> testRule = new ActivityTestRule<>(
        HelloActivity.class, false, false
    );

    public void encontrandonosEnPantallaHello() {
        testRule.launchActivity(null);
    }

    public void mostrandoBotonSayHelloActivado() {
        onView(withId(R.id.sayHelloButton))
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()));
    }

    public void mostrandoBotonGoByeActivado() {
        onView(withId(R.id.goByeButton))
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()));
    }

    public void pulsemosBotonSayHello() {
        onView(withId(R.id.sayHelloButton)).perform(click());
    }


    public void mostrandoMensajeVacio() {
        onView(withId(R.id.helloMessage))
            .check(matches(isDisplayed()))
            .check(matches(withText("?")));
    }

    public void mostrandoMensajeHelloWorld() {
        onView(withId(R.id.helloMessage))
            .check(matches(isDisplayed()))
            .check(matches(withText("Hello World!")));
    }

}