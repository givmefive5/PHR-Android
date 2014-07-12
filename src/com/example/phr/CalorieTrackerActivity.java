package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.phr.adapter.CalorieAdapter;
import com.example.phr.model.Calorie;

public class CalorieTrackerActivity extends Activity {

	ListView mCalorieList;
	CalorieAdapter calorieAdapter;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calorie_tracker);
		setTitle("Calorie Tracker");
        getActionBar().setDisplayHomeAsUpEnabled(true);
		mCalorieList = (ListView) findViewById(R.id.listview_calorie);
				
		// FAKE DATA
		List<Calorie> list = new ArrayList<Calorie>();
		Calorie data1 = new Calorie("Jul","12",459,246,1100,1565,"213/1650",13);
		Calorie data2 = new Calorie("Jul","11",679,80,1100,1565,"679/1565",33);
		Calorie data3 = new Calorie("Jul","10",152,80,1100,1565,"152/1565",14);
		Calorie data4 = new Calorie("Jul","8",1100,80.0,1100,1565,"1100/1565",80);
		Calorie data5 = new Calorie("Jul","7",400,80,1100,1565,"400/1565",40);
		Calorie data6 = new Calorie("Jul","6",598,80,1100,1565,"598/1565",50);
		Calorie data7 = new Calorie("Jul","4",152,80,1100,1565,"152/1565",14);
		
		list.add(data1);
		list.add(data2);
		list.add(data3);
		list.add(data4);
		list.add(data5);
		list.add(data6);
		list.add(data7);
		

		calorieAdapter = new CalorieAdapter(getApplicationContext(), list);
		mCalorieList.setAdapter(calorieAdapter);
		mCalorieList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("calorie", "CLICKED!");
				
				
			}
		});
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_tracker_help, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        switch (item.getItemId()) 
        {
        case android.R.id.home: 
            onBackPressed();
            break;
        default:
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
	

}
