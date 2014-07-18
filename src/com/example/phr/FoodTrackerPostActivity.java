package com.example.phr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FoodTrackerPostActivity extends Activity {
	
	TextView mTextViewFoodName;
	LinearLayout mBtnFoodDate;
	private ImageButton mBtnAddPhoto;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food_tracker_post);
		setTitle("Food");
		
		mTextViewFoodName = (TextView) findViewById(R.id.textViewFoodName);
		
		mTextViewFoodName.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						FoodTrackerSearchActivity.class);
				startActivity(intent);
			}
		});
		
		


		
		mBtnAddPhoto = (ImageButton)findViewById(R.id.btnAddImageFood);
		mBtnAddPhoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_status_post, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_item_status_post:
			onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
}
