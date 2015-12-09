package com.example.dustin.wassermanandroidfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dustin.wassermanandroidfinal.Host;
import com.example.dustin.wassermanandroidfinal.Meeting;
import com.example.dustin.wassermanandroidfinal.DBHandler;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText hostEmailEditText;

    public static int hostId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hostEmailEditText = (EditText) findViewById(R.id.hostEmailEditText);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void addHost(View v){
        DBHandler dbHandler = new DBHandler(this, null);

        if(!hostEmailEditText.getText().toString().trim().equals("") ) {
            Host host = new Host(hostEmailEditText.getText().toString());

            dbHandler.addHost(host);
            Toast.makeText(this, "Host Added!",
                    Toast.LENGTH_LONG).show();

            Host [] hosts = dbHandler.getHosts();

            hostId = hosts[hosts.length - 1].get_id();

        } else {
            Toast.makeText(this, "Please enter a host email!",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void goToAddMeeting(View v){
        DBHandler dbHandler = new DBHandler(this, null);
        if(dbHandler.getHosts() != null){
            intent = new Intent(this, add_meeting.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "You must add a host!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void goToHostResults(View v){
        DBHandler dbHandler = new DBHandler(this, null);
        if(dbHandler.getHosts() != null){
            intent = new Intent(this, host_results.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "You must add a host!",
                    Toast.LENGTH_LONG).show();
        }
    }

}
