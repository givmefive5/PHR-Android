package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.phr.adapter.StatusAdapter;
import com.example.phr.model.Status;

public class ActivitiesTrackerActivity extends Activity {
	
	StatusAdapter statusAdapter;
	ListView mActivityList;
	ImageButton mBtnAddActivity;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activities_tracker);
		mActivityList = (ListView) findViewById(R.id.listViewActivityTracker);
        getActionBar().setDisplayHomeAsUpEnabled(true);
		statusAdapter = new StatusAdapter(getApplicationContext(), generateData());
		mActivityList.setAdapter(statusAdapter);
		
		mBtnAddActivity = (ImageButton) findViewById(R.id.btnAddActivity);
		mBtnAddActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						ActivitiesTrackerPostActivity.class);
				startActivity(intent);
			}
		});
	}

	private List<Status> generateData() {
		List<Status> list = new ArrayList<Status>();
		
		Status activity1 = new Status();
		activity1.setActionHolder("Doing");
		activity1.setActionName("swimming");
		activity1.setDatettime("January 12, 2014 12:34AM");
		activity1.setStatus("YUM YUM YUM :)))");
		activity1.setActionImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		activity1.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(activity1);
		
		Status activity2 = new Status();
		activity2.setActionHolder("Doing");
		activity2.setActionName("reading a book");
		activity2.setDatettime("January 12, 2014 12:34AM");
		activity2.setStatus("weeeeeeeeeeeeeee");
		activity2.setActionImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		activity2.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(activity2);
		
		Status activity3 = new Status();
		activity3.setActionHolder("Doing");
		activity3.setActionName("fishing");
		activity3.setDatettime("January 12, 2014 12:34AM");
		activity3.setStatus("eat today die tom");
		activity3.setActionImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		activity3.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(activity3);
		
		Status activity4 = new Status();
		activity4.setActionHolder("hatching an egg");
		activity4.setActionName("coffee");
		activity4.setDatettime("January 12, 2014 12:34AM");
		activity4.setStatus("good morning!");
		activity4.setActionImgUrl(getResources().getDrawable(R.drawable.icon_activity));
		activity4.setPostViaImgUrl(getResources().getDrawable(R.drawable.icon_small_facebook));
		list.add(activity4);
		

		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
		list.add(activity4);
		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
		list.add(activity4);
		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
		list.add(activity4);
		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
		list.add(activity4);
		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
		list.add(activity4);
		
		return list;
	}
	

}
