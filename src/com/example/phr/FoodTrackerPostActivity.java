package com.example.phr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FoodTrackerPostActivity extends Activity {
	
	TextView mTextViewFoodName;
	LinearLayout mBtnFoodDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_tracker_post);
		
		mTextViewFoodName = (TextView) findViewById(R.id.textViewFoodName);
		
		mTextViewFoodName.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						FoodTrackerSearchActivity.class);
				startActivity(intent);
			}
		});
		/*
		mBtnFoodDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						FoodTrackerSearchActivity.class);
				startActivity(intent);
			}
		});
		*/
	}
}
