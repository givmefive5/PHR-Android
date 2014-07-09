package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WeightTrackerPostActivity extends Activity {

	private Spinner mSpinner;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_tracker_post);
		 
		addItemsOnSpinner();
	}
	
	public void addItemsOnSpinner() {
		mSpinner = (Spinner) findViewById(R.id.dropdownWeight);
		List<String> list = new ArrayList<String>();
		list.add("kg");
		list.add("lbs");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(dataAdapter);
	}
}