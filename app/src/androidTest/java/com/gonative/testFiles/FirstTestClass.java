package com.gonative.testFiles;

import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.gonative.android.MainActivity;
import io.gonative.android.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FirstTestClass{


    @Rule
    public ActivityScenarioRule<MainActivity> activityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void changeTest() throws InterruptedException {
        onView(withId(R.id.action_refresh)).perform(click());

        for(int i = 0; i < 3; i++){
            onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
            onData(anything()).inAdapterView(withId(R.id.drawer_list)).atPosition(i).perform(click());
            Thread.sleep(2000);
        }
    }
}
