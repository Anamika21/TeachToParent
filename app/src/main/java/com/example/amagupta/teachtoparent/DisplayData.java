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
import java.util.Set;


public class DisplayData extends ActionBarActivity {
    public Bundle myBundle = null;
    protected  static String EXTRA_MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        Intent intent = getIntent();
        myBundle = intent.getExtras();//BundleExtra();

        final ListView listview = (ListView) findViewById(R.id.listViewData);

        Set<String> myKeys = myBundle.keySet();
        String[] values = myKeys.toArray(new String[myKeys.size()]);
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length-2; i++) {
            list.add(values[i] + "     " + myBundle.get(values[i]).toString());
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

               // final String actionName = (String) parent.getItemAtPosition(position);
               // L//ist<String> myValues = myData.get(actionName);
                //String[] message = new String[]{RollNumber, actionName};
               // sendMessage(message, myValues);
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_data, menu);
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
