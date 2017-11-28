
/**
 * Created by DanielJimenez on 11/26/17.
 */
package com.brandi.discoevents;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import static com.brandi.discoevents.R.id.ListBookmarkedEvents;

public class Bookmarks extends AppCompatActivity {

    globals g = globals.getInstance();

    // Intent used for the tag search button, this is used in the onClick listener
    private Intent intent;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //sends back to home
                    intent = new Intent(Bookmarks.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    //sends to allEvents
                    intent = new Intent(Bookmarks.this, allEvents.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    //does nothing because is in bookmarks
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmarks);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_notifications);
        // Make array adapter to show results
        ListView listview = (ListView) findViewById(ListBookmarkedEvents);
        ListAdapter eventAdapter = new CustomAdapter(this, g.getBookmarks());
        listview.setAdapter(eventAdapter);

        listview.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // This is the code that allows the tagSearch button to take the app to the tagSearchCheckboxes class/fragment
                    EventData data = (EventData) parent.getItemAtPosition(position);
                    g.deleteBookmark(data);
                    Toast.makeText(getApplicationContext(), "Removed Event to Bookmark", Toast.LENGTH_SHORT).show();
                }
            }
        );
    }
}