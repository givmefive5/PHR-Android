package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import com.example.phr.adapter.WeightTrackerAdapter;
import com.example.phr.model.GroupedWeightStatus;
import com.example.phr.model.Status;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class WeightTrackerActivity extends Activity {
	
	WeightTrackerAdapter weightAdapter;
	ListView mWeightList;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_tracker);
		mWeightList = (ListView) findViewById(R.id.listViewWeightTracker);
        getActionBar().setDisplayHomeAsUpEnabled(true);
		weightAdapter = new WeightTrackerAdapter(getApplicationContext(), generateData());
		mWeightList.setAdapter(weightAdapter);
	}

	private List<GroupedWeightStatus> generateData() {
		List<GroupedWeightStatus> list = new ArrayList<GroupedWeightStatus>();
		
		GroupedWeightStatus day1 = new GroupedWeightStatus();
		day1.setMonth("May");
		day1.setDay("2");
		day1.setAverage("120 lbs");
		
		ArrayList<Status> sList = new ArrayList<Status>();
		Status gain = new Status();
		gain.setActionHolder("weighting");
		gain.setActionName("100 lbs");
		gain.setDatettime("12:34AM");
		sList.add(gain);
		Status loose = new Status();
		loose.setActionHolder("weighting");
		loose.setActionName("98 lbs");
		loose.setDatettime("11:20PM");
		sList.add(loose);
		
		day1.setWeightStatusList(sList);
		
		//----------------------
		

		GroupedWeightStatus day2 = new GroupedWeightStatus();
		day2.setMonth("May");
		day2.setDay("13");
		day2.setAverage("140 lbs");
		
		ArrayList<Status> sList2 = new ArrayList<Status>();
		Status gain21 = new Status();
		gain21.setActionHolder("weighting");
		gain21.setActionName("10 lbs");
		gain21.setDatettime("12:34AM");
		sList2.add(gain21);
		Status loose22 = new Status();
		loose22.setActionHolder("weighting");
		loose22.setActionName("48 lbs");
		loose22.setDatettime("11:20PM");
		sList2.add(loose22);
		Status loose23 = new Status();
		loose23.setActionHolder("weighting");
		loose23.setActionName("58 lbs");
		loose23.setDatettime("1:20PM");
		sList2.add(loose23);
		
		day2.setWeightStatusList(sList2);
		
		//----------------------
		

		GroupedWeightStatus day3 = new GroupedWeightStatus();
		day3.setMonth("May");
		day3.setDay("22");
		day3.setAverage("70 lbs");
		
		ArrayList<Status> sList3 = new ArrayList<Status>();
		Status gain31 = new Status();
		gain31.setActionHolder("weighting");
		gain31.setActionName("70 lbs");
		gain31.setDatettime("12:34AM");
		sList3.add(gain31);
		
		day3.setWeightStatusList(sList3);
		
		
		list.add(day1);
		list.add(day2);
		list.add(day3);
		list.add(day1);
		list.add(day2);
		list.add(day3);
		list.add(day1);
		list.add(day2);
		list.add(day3);
		
		return list;
	}

}
