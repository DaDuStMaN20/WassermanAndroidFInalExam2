package com.example.dustin.wassermanandroidfinal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class host_results extends AppCompatActivity {

    Host [] hostData;

    ListAdapter adapter;

    DBHandler dbHandler = new DBHandler(this, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        String [] noPlayers = {"No players found!"};

        hostData = dbHandler.getHosts();

        if (hostData != null){
            adapter = new HostResultsAdapter(this, hostData);
        } else {
            //Set out List Adpater to an ArrayAdapter which converts array
            // to List Items, in this case List Items are Strings
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noPlayers);
        }*/
    }

}
