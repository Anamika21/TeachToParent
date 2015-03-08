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


public class ParentResult extends ActionBarActivity {

    private String RollNumber="";
    protected  static String EXTRA_MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_result);
        Intent intent = getIntent();
        RollNumber = intent.getStringExtra(ParentHome.EXTRA_MESSAGE);

        final ListView listview = (ListView) findViewById(R.id.listViewResults);
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


    private void sendMessage(String[] item, List<String> values) {
        //Map<String,  List<String>> travellerData = populateData();
        //List<String> travellers = travellerData.get(item[1]);
        Bundle mBundle = new Bundle();
        mBundle.putString("Roll Number", item[0]);
        mBundle.putString("actionName", item[1]);

        for (int i = 0; i < values.size(); i++) {
            String[] splits = values.get(i).split(",");
            mBundle.putString(splits[0], splits[1]);
        }

        Intent intent = new Intent(this, DisplayData.class);
        intent.putExtras(mBundle);//putStringArrayListExtra(EXTRA_MESSAGE, item);
        //intent.putExtra("Train Number", item[0]);
        startActivity(intent);
    }

    public Map<String, List<String>> populateData()
    {

        Map<String, List<String>> notificationData = new LinkedHashMap<String, List<String>>();
        notificationData.put("Unit Tests 1", Arrays.asList("English,20/50", "Hindi,30/50", "Maths,40/50"));
        notificationData.put("Half Yearly", Arrays.asList("English,20/50", "Hindi,30/50", "Maths,40/50"));
        return notificationData;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent_result, menu);
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
