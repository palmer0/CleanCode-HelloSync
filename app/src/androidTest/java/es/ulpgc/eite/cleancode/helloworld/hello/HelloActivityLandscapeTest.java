package es.ulpgc.eite.cleancode.helloworld.hello;


import android.content.pm.ActivityInfo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.helloworld.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HelloActivityLandscapeTest {

  @Rule
  public ActivityTestRule<HelloActivity> mActivityTestRule =
      new ActivityTestRule<>(HelloActivity.class);

  @Test
  public void helloActivityLandscapeTest() {

    // GIVEN
    ViewInteraction textView0 = onView(
        allOf(withId(R.id.helloMessage), withText("?"),isDisplayed()));
    textView0.check(matches(withText("?")));

    // WHEN
    ViewInteraction appCompatButton = onView(
        allOf(withId(R.id.sayHelloButton), withText("Say Hello"), isDisplayed()));
    appCompatButton.perform(click());

    // THEN & GIVEN
    ViewInteraction textView = onView(
        allOf(withId(R.id.helloMessage), withText("Hello World!"),isDisplayed()));
    textView.check(matches(withText("Hello World!")));

    // -------------------------

    // WHEN
    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    // THEN & GIVEN
    ViewInteraction textView2 = onView(
        allOf(withId(R.id.helloMessage), withText("Hello World!"),isDisplayed()));
    textView2.check(matches(withText("Hello World!")));

    // -------------------------

    // WHEN
    ViewInteraction appCompatButton2 = onView(
        allOf(withId(R.id.goByeButton), withText("Go Bye"), isDisplayed()));
    appCompatButton2.perform(click());

    // THEN & GIVEN
    ViewInteraction textView3 = onView(
        allOf(withId(R.id.byeMessage), withText("Hello World!"), isDisplayed()));
    textView3.check(matches(withText("Hello World!")));

    // -------------------------

    // WHEN
    ViewInteraction appCompatButton3 = onView(
        allOf(withId(R.id.sayByeButton), withText("Say Bye"),isDisplayed()));
    appCompatButton3.perform(click());

    // THEN & GIVEN
    ViewInteraction textView4 = onView(
        allOf(withId(R.id.byeMessage), withText("Bye World!"),isDisplayed()));
    textView4.check(matches(withText("Bye World!")));

    // -------------------------

    // WHEN
    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    // THEN & GIVEN
    ViewInteraction textView5 = onView(
        allOf(withId(R.id.byeMessage), withText("Bye World!"), isDisplayed()));
    textView5.check(matches(withText("Bye World!")));

    // -------------------------

    // WHEN
    ViewInteraction appCompatButton4 = onView(
        allOf(withId(R.id.goHelloButton), withText("Go Hello"),isDisplayed()));
    appCompatButton4.perform(click());

    // THEN & GIVEN
    ViewInteraction textView6 = onView(
        allOf(withId(R.id.helloMessage), withText("Bye World!"),isDisplayed()));
    textView6.check(matches(withText("Bye World!")));

    // -------------------------


    // WHEN
    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    // THEN & GIVEN
    ViewInteraction textView7 = onView(
        allOf(withId(R.id.helloMessage), withText("Bye World!"),isDisplayed()));
    textView7.check(matches(withText("Bye World!")));

    // -------------------------

    // WHEN
    ViewInteraction appCompatButton5 = onView(
        allOf(withId(R.id.sayHelloButton), withText("Say Hello"),isDisplayed()));
    appCompatButton5.perform(click());

    // THEN & GIVEN
    ViewInteraction textView8 = onView(
        allOf(withId(R.id.helloMessage), withText("Hello World!"),isDisplayed()));
    textView8.check(matches(withText("Hello World!")));

    // -------------------------

    // WHEN
    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    // THEN
    ViewInteraction textView9 = onView(
        allOf(withId(R.id.helloMessage), withText("Hello World!"), isDisplayed()));
    textView9.check(matches(withText("Hello World!")));
  }

}
