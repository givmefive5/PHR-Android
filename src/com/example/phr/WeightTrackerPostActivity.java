package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class WeightTrackerPostActivity extends Activity {

	private Spinner mSpinner;
	private ImageButton mBtnAddPhoto;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_tracker_post);
		setTitle("Weight");
		addItemsOnSpinner();
		

		
		mBtnAddPhoto = (ImageButton)findViewById(R.id.btnAddImageWeight);
		mBtnAddPhoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivity(intent);
			}
		});
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