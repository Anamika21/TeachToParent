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


public class ParentHome extends ActionBarActivity {

    protected static String EXTRA_MESSAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_home);

        Intent intent = getIntent();
        final String RollNumber = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);


        final ListView listview = (ListView) findViewById(R.id.listView);
        String[] values = new String[] { "NOTIFICATIONS", "SCHEDULE", "RESULT", "APPOINTMENT", "FEEDBACK"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
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
                sendMessage(message);
            }

        });
    }


    private void sendMessage(String[] item) {

       // Map<String,  List<String>> stu = populateData();
        String actionName = item[1];
        if(actionName.equals("FEEDBACK")) {
            Intent intent = new Intent(this, ParentFeedback.class);
            intent.putExtra(EXTRA_MESSAGE, item[0]);
            startActivity(intent);
        }
        if(actionName.equals("NOTIFICATIONS"))
        {Intent intent = new Intent(this, ParentNotification.class);
            intent.putExtra(EXTRA_MESSAGE, item[0]);
            startActivity(intent);}
        if(actionName.equals("SCHEDULE"))
        {Intent intent = new Intent(this, ParentSchedule.class);
            intent.putExtra(EXTRA_MESSAGE, item[0]);
            startActivity(intent);}
        if(actionName.equals("RESULT"))
        {Intent intent = new Intent(this, ParentResult.class);
            intent.putExtra(EXTRA_MESSAGE, item[0]);
            startActivity(intent);}
        if(actionName.equals("APPOINTMENT"))
        {Intent intent = new Intent(this, ParentAppointment.class);
            intent.putExtra(EXTRA_MESSAGE, item[0]);
            startActivity(intent);}
        Bundle mBundle = new Bundle();

     /*   for (int i = 0; i < travellers.size(); i++) {
            if(item[1].equals("S1"))
                mBundle.putString(travellers.get(i), "Y");
            if(item[1].equals("S2"))
                mBundle.putString(travellers.get(i), "P");
            if(item[1].equals("S3"))
                mBundle.putString(travellers.get(i), "P");
            if(item[1].equals("Waiting List")) {
                mBundle.putString(travellers.get(0), "RAC1");
                mBundle.putString(travellers.get(1), "RAC2");
                mBundle.putString(travellers.get(2), "WL1");
            }

        }*/
        /*mBundle.putString(travellers.get(0), "Y");
        mBundle.putString(travellers.get(1), "Y");
        mBundle.putString(travellers.get(2), "Y");
        mBundle.putString(travellers.get(9), "RAC1");
        mBundle.putString(travellers.get(10), "RAC2");
        mBundle.putString(travellers.get(11), "WL1");
*/

        /*Intent intent = new Intent(this, ParentFeedback.class);
        intent.putExtras(mBundle);//putStringArrayListExtra(EXTRA_MESSAGE, item);
        //intent.putExtra("Train Number", item[0]);
        startActivity(intent);*/
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent_home, menu);
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
