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
import android.widget.ToggleButton;

public class ActivitiesTrackerPostActivity extends Activity { 
	
	private ToggleButton toggleSharing;
	private ImageButton mBtnAddPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activities_tracker_post);
		setTitle("Activities");
		toggleSharing = (ToggleButton) findViewById(R.id.togglebuttonActivitySharing);
		

		
		mBtnAddPhoto = (ImageButton)findViewById(R.id.btnAddImageActivity);
		mBtnAddPhoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivity(intent);
			}
		});
	}
	
	public Boolean getSharingOption() {
		// true = post on fb
		// false = dont post
	    return toggleSharing.isChecked();
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
