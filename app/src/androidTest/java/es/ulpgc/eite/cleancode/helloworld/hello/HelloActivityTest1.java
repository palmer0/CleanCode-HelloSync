package es.ulpgc.eite.cleancode.helloworld.hello;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.helloworld.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HelloActivityTest1 {

  @Rule
  public ActivityTestRule<HelloActivity> mActivityTestRule = new ActivityTestRule<>(HelloActivity.class);

  @Test
  public void helloActivityTest1() {
    ViewInteraction appCompatButton = onView(
        allOf(withId(R.id.sayHelloButton), withText("Say Hello"),
            childAtPosition(
                allOf(withId(R.id.linearLayout),
                    childAtPosition(
                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        2)),
                0),
            isDisplayed()));
    appCompatButton.perform(click());

    ViewInteraction textView = onView(
        allOf(withId(R.id.helloMessage), withText("Hello World!"),
            childAtPosition(
                childAtPosition(
                    withId(android.R.id.content),
                    0),
                0),
            isDisplayed()));
    textView.check(matches(withText("Hello World!")));

    ViewInteraction appCompatButton2 = onView(
        allOf(withId(R.id.goByeButton), withText("Go Bye"),
            childAtPosition(
                allOf(withId(R.id.linearLayout),
                    childAtPosition(
                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        2)),
                1),
            isDisplayed()));
    appCompatButton2.perform(click());

    ViewInteraction textView2 = onView(
        allOf(withId(R.id.byeMessage), withText("Hello World!"),
            childAtPosition(
                childAtPosition(
                    withId(android.R.id.content),
                    0),
                0),
            isDisplayed()));
    textView2.check(matches(withText("Hello World!")));

    ViewInteraction appCompatButton3 = onView(
        allOf(withId(R.id.sayByeButton), withText("Say Bye"),
            childAtPosition(
                allOf(withId(R.id.linearLayout),
                    childAtPosition(
                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        2)),
                0),
            isDisplayed()));
    appCompatButton3.perform(click());

    ViewInteraction textView3 = onView(
        allOf(withId(R.id.byeMessage), withText("Hello World!"),
            childAtPosition(
                childAtPosition(
                    withId(android.R.id.content),
                    0),
                0),
            isDisplayed()));
    textView3.check(matches(withText("Bye World!")));

    ViewInteraction appCompatButton4 = onView(
        allOf(withId(R.id.goHelloButton), withText("Go Hello"),
            childAtPosition(
                allOf(withId(R.id.linearLayout),
                    childAtPosition(
                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        2)),
                1),
            isDisplayed()));
    appCompatButton4.perform(click());

    ViewInteraction textView4 = onView(
        allOf(withId(R.id.helloMessage), withText("Hello World!"),
            childAtPosition(
                childAtPosition(
                    withId(android.R.id.content),
                    0),
                0),
            isDisplayed()));
    textView4.check(matches(withText("Bye World!")));
  }

  private static Matcher<View> childAtPosition(
      final Matcher<View> parentMatcher, final int position) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("Child at position " + position + " in parent ");
        parentMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely(View view) {
        ViewParent parent = view.getParent();
        return parent instanceof ViewGroup && parentMatcher.matches(parent)
            && view.equals(((ViewGroup) parent).getChildAt(position));
      }
    };
  }
}
