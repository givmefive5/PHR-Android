package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calorie_tracker);
		setTitle("Calorie Tracker");
		mCalorieList = (ListView) findViewById(R.id.listview_calorie);
				
		// FAKE DATA
		List<Calorie> list = new ArrayList<Calorie>();
		Calorie data1 = new Calorie("Jun","05",1180.0,80.0,1100,1565,"1100/1565",90);
		
		Calorie data2 = new Calorie("Jun","07",1180,80,1100,1565,"900/1565",80);

		Calorie data3 = new Calorie("Jun","08",1180,80,1100,1565,"750/1565",70);

		list.add(data3);
		list.add(data2);
		list.add(data1);
		

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

}
