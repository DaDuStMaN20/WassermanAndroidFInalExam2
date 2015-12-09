package com.example.dustin.wassermanandroidfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class add_meeting extends AppCompatActivity {

    EditText nameEditText;
    EditText descEditText;
    EditText locationEditText;
    EditText dateEditText;
    EditText timeEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        descEditText = (EditText) findViewById(R.id.descEditText);
        locationEditText = (EditText) findViewById(R.id.locationEditText);
        dateEditText = (EditText) findViewById(R.id.dateEditText);
        timeEditText = (EditText) findViewById(R.id.timeEditText);



    }

    public void addMeeting(View v){
        DBHandler dbHandler  = new DBHandler(this, null);
        if(!nameEditText.getText().toString().trim().equals("") ||
                !descEditText.getText().toString().trim().equals("") ||
                !locationEditText.getText().toString().trim().equals("") ||
                !dateEditText.getText().toString().trim().equals("") ||
                !timeEditText.getText().toString().trim().equals("") ){

            Meeting meet = new Meeting(nameEditText.getText().toString().trim(),
                    descEditText.getText().toString().trim(),
                    locationEditText.getText().toString().trim(),
                    dateEditText.getText().toString().trim(),
                    timeEditText.getText().toString().trim(),
                    MainActivity.hostId);

            dbHandler.addMeeting(meet);

        } else {
            Toast.makeText(this, "You must fill out all fields!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void goToMeetingResults(View v){
        DBHandler dbHandler = new DBHandler(this, null);
        if(dbHandler.getMeetings() != null){
            Intent intent = new Intent(this, meeting_results.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "You must add a meeting!",
                    Toast.LENGTH_LONG).show();
        }
    }

}
