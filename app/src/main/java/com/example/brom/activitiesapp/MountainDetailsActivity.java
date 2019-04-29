package com.example.brom.activitiesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent mountainDetailsIntent = getIntent();

        String message = mountainDetailsIntent.getStringExtra(MainActivity.X_MESSAGE);

        TextView textView = findViewById(R.id.TextFromMain);

        textView.setText(message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
