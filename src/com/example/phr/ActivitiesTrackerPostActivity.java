package com.example.phr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ActivitiesTrackerPostActivity extends Activity { 
	
	private ToggleButton toggleSharing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activities_tracker_post);
		toggleSharing = (ToggleButton) findViewById(R.id.togglebuttonActivitySharing);
	}
	
	public Boolean getSharingOption() {
		// true = post on fb
		// false = dont post
	    return toggleSharing.isChecked();
	}
}
