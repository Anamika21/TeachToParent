package com.example.amagupta.teachtoparent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ParentSchedule extends ActionBarActivity {

    private String RollNumber="";
    protected  static String EXTRA_MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_schedule);
     //   initializeCalendar();
        Intent intent = getIntent();
        RollNumber = intent.getStringExtra(ParentHome.EXTRA_MESSAGE);

        final ListView listview = (ListView) findViewById(R.id.listViewSchedule);
        Map<String, List<String>> myData = populateData();
        Set<String> myKeys = myData.keySet();
        String[] values = myKeys.toArray(new String[myKeys.size()]);
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < myKeys.size(); ++i) {
            list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                final String actionName = (String) parent.getItemAtPosition(position);
                String[] message = new String[]{RollNumber, actionName};
                //sendMessage(message);
            }

        });

    }

    public Map<String, List<String>> populateData()
    {

        Map<String, List<String>> notificationData = new LinkedHashMap<String, List<String>>();
        notificationData.put("Unit Tests 1, FROM 5th March to 15th March", Arrays.asList("Hello Parent, The Mid Term Exams are starting from 19th March, 2015. Please plan accordingly."));
        notificationData.put("Half Yearly, FROM 5th May to 20th May", Arrays.asList("FIRST PTA is due on 11/March/2015"));
        notificationData.put("Unit Tests 2, From 10th August to 20th August", Arrays.asList("ATHELETIC - 11/March/2015"));
        notificationData.put("Finale, From 10th November to 25th November ", Arrays.asList("Art EXHIBITION - 15/March/2015"));
        return notificationData;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent_schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
