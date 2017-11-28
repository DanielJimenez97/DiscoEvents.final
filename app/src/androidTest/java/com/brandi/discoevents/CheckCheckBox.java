package com.brandi.discoevents;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheckCheckBox {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkCheckBox() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonSearchTabs), withText("Search"),
                        withParent(allOf(withId(R.id.LinearTagSearch),
                                withParent(withId(R.id.container)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3593517);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.checkBoxDept), withText("Department Events"),
                        withParent(withId(R.id.linearCheckLayout)),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonTagSearch), withText("Search"), isDisplayed()));
        appCompatButton2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3590803);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.EventData_List),
                                withParent(withId(R.id.layoutTagList))),
                        0),
                        isDisplayed()));
        linearLayout.perform(click());

        pressBack();

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3575191);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatCheckBox2 = onView(
                allOf(withId(R.id.checkBoxCE), withText("Computer Engineering"),
                        withParent(withId(R.id.linearCheckLayout)),
                        isDisplayed()));
        appCompatCheckBox2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.buttonTagSearch), withText("Search"), isDisplayed()));
        appCompatButton3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3589277);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView = onView(
                allOf(withId(R.id.DataText), withText("Selected Events:"),
                        childAtPosition(
                                allOf(withId(R.id.layoutTagList),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Selected Events:")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textEventName), withText("Event: Discovery Park Career Fair"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.EventData_List),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Event: Discovery Park Career Fair")));

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.navigation),
                        childAtPosition(
                                allOf(withId(R.id.LinearBottomContentBookmark),
                                        childAtPosition(
                                                withId(R.id.layoutTagList),
                                                2)),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.action_bar),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_container),
                                        childAtPosition(
                                                withId(R.id.decor_content_parent),
                                                0)),
                                0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withText("DiscoEvents"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("DiscoEvents")));

        pressBack();

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
