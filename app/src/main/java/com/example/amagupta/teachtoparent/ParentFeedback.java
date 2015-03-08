package com.example.amagupta.teachtoparent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class ParentFeedback extends ActionBarActivity {

    private String RollNumber="";
    protected  static String EXTRA_MESSAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_feedback);
        Intent intent = getIntent();
        RollNumber = intent.getStringExtra(ParentHome.EXTRA_MESSAGE);

    }

    private void showToast(String text, int duration) {
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
    public void onSuccess(View view)
    {
        showToast("FeedBack Submitted Successfully", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, ParentHome.class);
        intent.putExtra(EXTRA_MESSAGE, RollNumber);
        startActivity(intent);
    }
    public void onCancel(View view)
    {
        showToast("FeedBack Submission Cancelled..!!", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, ParentHome.class);
        intent.putExtra(EXTRA_MESSAGE, RollNumber);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent__feedback, menu);
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
