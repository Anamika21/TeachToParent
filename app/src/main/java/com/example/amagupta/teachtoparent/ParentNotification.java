package com.example.amagupta.teachtoparent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ParentNotification extends ActionBarActivity {

    private String RollNumber="";
    protected  static String EXTRA_MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_notification);
        Intent intent = getIntent();
        RollNumber = intent.getStringExtra(ParentHome.EXTRA_MESSAGE);

        final ListView listview = (ListView) findViewById(R.id.listViewNotifications);
        final Map<String, List<String>> myData = populateData();
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
                List<String> myValues = myData.get(actionName);
                String[] message = new String[]{RollNumber, actionName};
                sendMessage(message, myValues);
            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent__schedule, menu);
        return true;
    }

    private void sendMessage(String[] item, List<String> values) {
        Bundle mBundle = new Bundle();
        mBundle.putString("Roll Number", item[0]);
        mBundle.putString("actionName", item[1]);

        mBundle.putString("Details", values.get(0));

        Intent intent = new Intent(this, DisplayData.class);
        intent.putExtras(mBundle);//putStringArrayListExtra(EXTRA_MESSAGE, item);
        //intent.putExtra("Train Number", item[0]);
        startActivity(intent);
        /*Map<String,  List<String>> notifications_map = populateData();
        //String> notification = notifications_map.get(item[1]);
        Bundle mBundle = new Bundle();
        //for (int i = 0; i < notification.size(); i++) {
            if(item[1].equals("MID TERM EXAM"))
                mBundle.putString(notification.get(i), "Y");
            if(item[1].equals("PARENT TEACHERS MEETING"))
                mBundle.putString(notification.get(i), "P");
            if(item[1].equals("SPORTS DAY"))
                mBundle.putString(notification.get(i), "P");
            if(item[1].equals("EXHIBITIONS")) {
                mBundle.putString(notification.get(0), "RAC1");
                mBundle.putString(notification.get(1), "RAC2");
                mBundle.putString(notification.get(2), "WL1");
            }
*/
        //}
        /*mBundle.putString(travellers.get(0), "Y");
        mBundle.putString(travellers.get(1), "Y");
        mBundle.putString(travellers.get(2), "Y");
        mBundle.putString(travellers.get(9), "RAC1");
        mBundle.putString(travellers.get(10), "RAC2");
        mBundle.putString(travellers.get(11), "WL1");


        Intent intent = new Intent(this, SelectTraveller.class);
        intent.putExtras(mBundle);//putStringArrayListExtra(EXTRA_MESSAGE, item);
        //intent.putExtra("Train Number", item[0]);
        ParentNotification(intent);*/
    }

    public Map<String, List<String>> populateData()
    {

        Map<String, List<String>> notificationData = new LinkedHashMap<String, List<String>>();
        notificationData.put("7/3/2015 MID TERM EXAM",  Arrays.asList("Hello Parent, The Mid Term Exams are starting from 19th March, 2015. Please plan accordingly."));
        notificationData.put("7/3/2015 PARENT TEACHERS MEETING", Arrays.asList("FIRST PTA is due on 11/March/2015"));
        notificationData.put("6/3/2015 SPORTS DAY", Arrays.asList("ATHELETIC - 11/March/2015"));
        notificationData.put("6/3/2015 EXHIBITIONS", Arrays.asList("Art EXHIBITION - 15/March/2015"));
        return notificationData;
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
