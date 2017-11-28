package com.brandi.discoevents;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    globals g = globals.getInstance();  // Global Variables

    // Intent used for the tag search button, this is used in the onClick listener
    private Intent intent;

    //function below listens for clicks on the navigation bar and runs switch statement based on click
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: // if home button is clicked
                    //does nothing because is in home
                    return true;
                case R.id.navigation_dashboard: // if the allEvents button is clicked, creates new intent called allEvents
                    intent = new Intent(MainActivity.this, allEvents.class);
                    startActivity(intent);
                    finish(); // closes current intent
                    return true;
                case R.id.navigation_notifications: // if bookmarks is clicked, creates bookmark intent
                    intent = new Intent(MainActivity.this, Bookmarks.class);
                    startActivity(intent);
                    finish(); // closes current intent
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView); // initializes calenderview variable based on calender
        calendarView.setDate(System.currentTimeMillis(), false, true); // sets calendar using system date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            //@RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) { //function listens for a date change

                // Setting the global variable for the clicked day on the calender that way pop can display the events corresponding to that date
                g.setYear(year);
                g.setDay(dayOfMonth);
                g.setMonth(month+1);

                month++; //idk wby but because it reads first months as 0
                startActivity(new Intent(MainActivity.this, Pop.class)); // starts popup class
            }
        });
    }

    // This is the code that allows the tagSearch button to take the app to the tagSearchCheckboxes class/fragment
    public void sendMessage(View view){
        intent = new Intent(MainActivity.this, tagSearchCheckboxes.class);
        startActivity(intent);
    }
}