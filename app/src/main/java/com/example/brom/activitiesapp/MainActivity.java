package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String X_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";

    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    private ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));
    private ArrayList<Mountain> mountainArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listData = new ArrayList<>(Arrays.asList(mountainNames));

        mountainArrayList.add(new Mountain("Matterhorn", "Alps", 4478));
        mountainArrayList.add(new Mountain("Mont Blanc", "Alps", 4808));
        mountainArrayList.add(new Mountain("Denali", "Alaska", 6190));
        Log.i("LAAKSO",mountainArrayList.get(0).getName());

        ArrayAdapter<Mountain> adapter=new ArrayAdapter<Mountain>(this, R.layout.list_item_textview, R.id.list_item_textview, mountainArrayList);

        ListView my_listview=(ListView) findViewById(R.id.my_listview);

        my_listview.setAdapter(adapter);

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                Intent mountainDetailsIntent = new Intent(getApplicationContext(), MountainDetailsActivity.class);
                String message = mountainArrayList.get(index).info();
                mountainDetailsIntent.putExtra(X_MESSAGE, message);
                startActivity(mountainDetailsIntent);
            }
        });
    }
}
