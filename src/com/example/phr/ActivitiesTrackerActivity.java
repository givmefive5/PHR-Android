package com.example.phr;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.phr.adapter.ActivityAdapter;
import com.example.phr.adapter.StatusAdapter;
import com.example.phr.model.Status;

public class ActivitiesTrackerActivity extends Activity {
	
	ActivityAdapter activityAdapter;
	ListView mActivityList;
	ImageView mBtnAddActivity;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activities_tracker);
		setTitle("Activity Tracker");
		mActivityList = (ListView) findViewById(R.id.listViewActivityTracker);
        getActionBar().setDisplayHomeAsUpEnabled(true);
		activityAdapter = new ActivityAdapter(getApplicationContext(), generateData());
		mActivityList.setAdapter(activityAdapter);
		
		mBtnAddActivity = (ImageView) findViewById(R.id.btnAddActivity);
		mBtnAddActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						ActivitiesTrackerPostActivity.class);
				startActivity(intent);
			}
		});
	}

	private List<com.example.phr.model.Activity> generateData() {
		List<com.example.phr.model.Activity> list = new ArrayList<com.example.phr.model.Activity>();
		
		com.example.phr.model.Activity activity1 = new com.example.phr.model.Activity();
		activity1.setAction("Swimming");
		activity1.setCalBurned("1200");
		activity1.setDate("February 4, 2012");
		activity1.setTime("5:55PM");
		activity1.setDuration("45 Mins");
		list.add(activity1);
		list.add(activity1);
		list.add(activity1);
		list.add(activity1);
		list.add(activity1);
		list.add(activity1);
		list.add(activity1);
		list.add(activity1);
		
		/*		Status activity1 = new Status();
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
		list.add(activity4);*/
		
		return list;
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
